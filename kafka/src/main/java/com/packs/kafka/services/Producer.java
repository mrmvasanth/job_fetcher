package com.packs.kafka.services;

import com.packs.kafka.config.Constants.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import static com.packs.kafka.config.Constants.TARGET_TOPIC;

@Service
public class Producer {
    private static final Logger logger = LoggerFactory.getLogger(Producer.class);

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Autowired
    FileReaderService fileReaderService;

    public void startReadingThread() throws Exception {
        while (true) {
            try {
                int jobsCount=fileReaderService.getJobsCount();
                sendMessage(Integer.toString(jobsCount));
                Thread.sleep(20000);
            } catch (InterruptedException ex) {
            }
        }
    }

    public void sendMessage(String jobsCount) {
        this.kafkaTemplate.send(TARGET_TOPIC, jobsCount);
    }
}