package ru.otus.lesson17hw.config;

import com.mongodb.ConnectionString;
import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractReactiveMongoConfiguration;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;
import ru.otus.lesson17hw.repository.AuthorReactiveRepository;

//@Configuration
@EnableReactiveMongoRepositories
        //(basePackages = "ru.otus.lesson17hw.repository")
public class Config
        extends AbstractReactiveMongoConfiguration
{

        @Override
        protected String getDatabaseName() {
            return "otus17";
        }

        @Override
        public MongoClient reactiveMongoClient() {
            return MongoClients.create();
        }

//        @Bean
//        public MongoClient mongoClient(){
//            return MongoClients.create(new ConnectionString("mongodb://localhost:27017"));
//        }
}
