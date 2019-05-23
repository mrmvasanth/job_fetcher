package com.packs.kafka.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import static com.packs.kafka.constants.ConstantsUtil.TARGET_TOPIC;

@Service
public class ProducerService {
    private static final Logger logger = LoggerFactory.getLogger(ProducerService.class);

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