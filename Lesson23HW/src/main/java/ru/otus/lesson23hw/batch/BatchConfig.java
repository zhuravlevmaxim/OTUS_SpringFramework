package ru.otus.lesson23hw.batch;

import org.springframework.batch.core.*;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.data.MongoItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoOperations;

import ru.otus.lesson23hw.domain.Author;
import ru.otus.lesson23hw.domain.Book;
import ru.otus.lesson23hw.domain.Comment;
import ru.otus.lesson23hw.entity.Genre;

import javax.sql.DataSource;
import java.util.*;
import java.util.stream.Collectors;

@EnableBatchProcessing
@Configuration
public class BatchConfig {

    @Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Autowired
    public StepBuilderFactory stepBuilderFactory;

    @Autowired
    DataSource dataSource;

    @Autowired
    MongoOperations mongoOperations;

    @Bean
    public MongoItemReader<Book> reader() {
        MongoItemReader<Book> mongoItemReader = new MongoItemReader<>();
        mongoItemReader.setName("bookReader");
        mongoItemReader.setTargetType(Book.class);
        mongoItemReader.setTemplate(mongoOperations);
        mongoItemReader.setQuery("{}");
        mongoItemReader.setSort(new HashMap<String, Sort.Direction>() {{
            put("_id", Sort.Direction.DESC);
        }});
        return mongoItemReader;
    }

    @Bean
    public ItemProcessor processor() {
        return new ItemProcessor<Book, ru.otus.lesson23hw.entity.Book>() {
            @Override
            public ru.otus.lesson23hw.entity.Book process(Book book) throws Exception {
                ru.otus.lesson23hw.entity.Book bookDB = new ru.otus.lesson23hw.entity.Book();
                bookDB.setName(book.getName());
                bookDB.setDescription(book.getDescription());
                bookDB.setContent(book.getContent());
                Collection<Author> authors = book.getAuthors();
                Collection<ru.otus.lesson23hw.entity.Author> authorsDB = new HashSet<>();
                authors.stream().map(author -> {
                    ru.otus.lesson23hw.entity.Author authorDB = new ru.otus.lesson23hw.entity.Author();
                    authorDB.setFirstName(author.getFirstName());
                    authorDB.setSecondName(author.getSecondName());
                    return authorDB;
                }).collect(Collectors.toCollection(() -> authorsDB));
                Collection<Comment> comments = book.getComments();
                Collection<ru.otus.lesson23hw.entity.Comment> commentsDB = new HashSet<>();
                comments.stream().map(comment -> {
                    ru.otus.lesson23hw.entity.Comment commentDB = new ru.otus.lesson23hw.entity.Comment();
                    commentDB.setComment(comment.getComment());
                    return commentDB;
                }).collect(Collectors.toCollection(() -> commentsDB));
                Genre genreDB = new Genre();
                genreDB.setGenre(book.getGenre().getGenre());
                bookDB.setAuthors(authorsDB);
                bookDB.setComments(commentsDB);
                bookDB.setGenre(genreDB);
                return bookDB;
            }
        };
    }

    @Bean
    public MyDBItemWriter writer() {
        return new MyDBItemWriter();
    }

    @Bean
    public Job importUserJob(Step step1) {
        return jobBuilderFactory.get("bookReader")
                .incrementer(new RunIdIncrementer())
                .flow(step1)
                .end()
                .listener(new JobExecutionListener() {
                    @Override
                    public void beforeJob(JobExecution jobExecution) {
                        System.out.println("Начало job");
                    }
                    @Override
                    public void afterJob(JobExecution jobExecution) {
                        System.out.println("Конец job");
                    }
                })
                .build();
    }

    @Bean
    public Step step1(MyDBItemWriter writer) {
        return stepBuilderFactory.get("step1")
                .chunk(5)
                .reader(reader())
                .processor(processor())
                .writer(writer)
                .listener(new ItemReadListener() {
                    public void beforeRead() { System.out.println("Начало чтения"); }
                    public void afterRead(Object o) { System.out.println("Конец чтения"); }
                    public void onReadError(Exception e) { System.out.println("Ошибка чтения"); }
                })
                .listener(new ItemWriteListener() {
                    public void beforeWrite(List list) { System.out.println("Начало записи"); }
                    public void afterWrite(List list) { System.out.println("Конец записи"); }
                    public void onWriteError(Exception e, List list) { System.out.println("Ошибка записи"); }
                })
                .listener(new ItemProcessListener() {
                    public void beforeProcess(Object o) {System.out.println("Начало обработки");}
                    public void afterProcess(Object o, Object o2) {System.out.println("Конец обработки");}
                    public void onProcessError(Object o, Exception e) {System.out.println("Ошибка обработки");}
                })
                .listener(new ChunkListener() {
                    public void beforeChunk(ChunkContext chunkContext) {System.out.println("Начало пачки");}
                    public void afterChunk(ChunkContext chunkContext) {System.out.println("Конец пачки");}
                    public void afterChunkError(ChunkContext chunkContext) {System.out.println("Ошибка пачки");}
                })
                .build();
    }
}
