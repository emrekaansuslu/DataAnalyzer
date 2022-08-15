package com.midas.dataAnalyzer.util;


import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.ServerAddress;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
public class MongoDBConfig {

    public String getDatabaseName() {
        return "midas";
    }

    @Bean
    public MongoClient mongoClient() {
        ServerAddress address = new ServerAddress("127.0.0.1",27017);
        MongoClientOptions mongoClientOptions = new MongoClientOptions.Builder().build();

        MongoClient client = new MongoClient(address,mongoClientOptions);
        return client;
    }

    @Bean
    public MongoDbFactory mongoDbFactory() {
        MongoDbFactory factory = new SimpleMongoDbFactory(mongoClient(),getDatabaseName());
        return factory;
    }


    public MongoTemplate mongoTemplate() {
        MongoTemplate template = new MongoTemplate(mongoDbFactory());
        return template;
    }
}
