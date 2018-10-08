package ru.otus.lesson21hw.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.otus.lesson21hw.domain.Author;
import ru.otus.lesson21hw.repository.AuthorRepository;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class AuthorService{

    @Autowired
    private AuthorRepository authorRepository;
    @Autowired
    private MongoOperations mongoOperations;

    private final static String ID = "id";
    private final static String FIRST_NAME = "firstName";
    private final static String SECOND_NAME = "secondName";

    @Secured("hasRole({ROLE_USER, ROLE_ADMIN})")
    public List<Author> getAuthors(){
        return authorRepository.findAll();
    }

    @Secured("hasRole(ROLE_ADMIN)")
    @Transactional(readOnly = false)
    public List<Author> deleteAuthor(String id){
        authorRepository.deleteById(id);
        return authorRepository.findAll();
    }

    @Secured("hasRole(ROLE_ADMIN)")
    @Transactional(readOnly = false)
    public Author editAuthor(Author author) {
        Query query = new Query();
        query.addCriteria(Criteria.where(ID).is(author.getId()));
        Update update = new Update();
        update.set(FIRST_NAME, author.getFirstName());
        update.set(SECOND_NAME, author.getSecondName());
        mongoOperations.updateFirst(query, update, Author.class);
        return authorRepository.findById(author.getId()).get();
    }

    @Secured("hasRole(ROLE_ADMIN)")
    @Transactional(readOnly = false)
    public List<Author> createNewAuthor(Author author){
        authorRepository.save(author);
        return authorRepository.findAll();
    }
}
