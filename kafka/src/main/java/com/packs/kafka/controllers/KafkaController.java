package com.packs.kafka.controllers;

import com.packs.kafka.services.Producer;
import com.packs.kafka.services.ProducerThread;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/kafka")
public class KafkaController {
    private final Producer producer;

    private static final String TOPIC = "topic1";

    @Autowired
    public KafkaController(Producer producer) {
        this.producer = producer;
    }

    @PostMapping(value = "/publish")
    public String sendMessageToKafkaTopic(@RequestParam("message") String message) {
        this.producer.sendMessage(message);
        return "published successfully";
    }

    @PostMapping(value = "/startserver")
    public String startServer(){
        boolean isAsync = false;
        ProducerThread producerThread = new ProducerThread(TOPIC, isAsync);
        producerThread.start();
        return "Server Started";
    }


}