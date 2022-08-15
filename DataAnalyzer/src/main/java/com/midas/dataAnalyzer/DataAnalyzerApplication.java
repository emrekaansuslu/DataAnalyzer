package com.midas.dataAnalyzer;

import com.midas.dataAnalyzer.model.DataNew;
import com.midas.dataAnalyzer.service.DataNewService;
import com.midas.dataAnalyzer.task.CreateInfoTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
@EnableMongoRepositories(basePackages = "com.midas.dataAnalyzer.repository")
public class DataAnalyzerApplication implements CommandLineRunner {


    @Autowired
    CreateInfoTask createInfoTask;



    public static void main(String[] args) {
        SpringApplication.run(DataAnalyzerApplication.class, args);
    }

    @Override
    public void run(String... strings) throws Exception {
//       ScheduledExecutorService scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
//        scheduledExecutorService.scheduleAtFixedRate(createInfoTask,0,100, TimeUnit.MILLISECONDS);


    }
}
