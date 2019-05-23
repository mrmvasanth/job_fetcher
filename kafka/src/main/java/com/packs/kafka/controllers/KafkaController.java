package com.packs.kafka.controllers;

import com.packs.kafka.services.Producer;
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

//    @PostMapping(value = "/publish")
//    public String sendMessageToKafkaTopic(@RequestParam("message") String message) {
//        this.producer.sendMessage(message);
//        this.producer.insertIntoCassandra(message);
//        return "published successfully";
//    }

    @GetMapping(value = "/start")
    public String sendMessageToKafkaTopic() throws Exception {
        this.producer.startReadingThread();
        return "started";
    }



}