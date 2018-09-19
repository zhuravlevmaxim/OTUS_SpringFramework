package ru.otus.lesson17hw.config;

import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;
import org.springframework.data.mongodb.config.AbstractReactiveMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@EnableReactiveMongoRepositories
public class Config extends AbstractReactiveMongoConfiguration {
        @Override
        protected String getDatabaseName() {
            return "otus17";
        }

        @Override
        public MongoClient reactiveMongoClient() {
            return MongoClients.create();
        }
}
