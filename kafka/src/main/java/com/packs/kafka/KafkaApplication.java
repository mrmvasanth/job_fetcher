package com.packs.kafka;


import com.packs.kafka.model.JobDetails;
import com.packs.kafka.repository.CassandraRepo;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class KafkaApplication{

    @Autowired
    CassandraRepo cassandraRepo;

    public static void main(String[] args) {
        SpringApplication.run(KafkaApplication.class, args);
    }




}
