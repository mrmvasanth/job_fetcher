package com.packs.kafka.services;


import com.packs.kafka.repository.CassandraRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.regex.*;

@Service
public class Producer {
    private static final Logger logger = LoggerFactory.getLogger(Producer.class);
    private static final String TOPIC = "topic1";

    @Autowired
    CassandraRepo cassandraRepo;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    FileReaderService fileReaderService;


    public void startReadingThread() throws Exception {
        int i = 0;
        while (true) {
            try {
                int jobsCount=fileReaderService.getJobsCount();
                sendMessage(Integer.toString(jobsCount));
                Thread.sleep(20000);
            } catch (InterruptedException ex) {
            }
            i++;
        }
    }

    public void sendMessage(String jobsCount) {
        this.kafkaTemplate.send(TOPIC, jobsCount);
    }



}