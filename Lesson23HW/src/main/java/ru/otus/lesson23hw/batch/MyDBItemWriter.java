package ru.otus.lesson23hw.batch;

import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import ru.otus.lesson23hw.entity.Book;
import ru.otus.lesson23hw.repository.BookRepository;

import java.util.List;

public class MyDBItemWriter implements ItemWriter<Book> {

    @Autowired
    private BookRepository bookRepositoryDB;

    @Override
    public void write(List<? extends Book> books) throws Exception {
        bookRepositoryDB.saveAll(books);
    }
}
