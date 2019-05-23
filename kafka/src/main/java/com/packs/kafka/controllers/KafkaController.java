package com.packs.kafka.controllers;

import com.packs.kafka.services.ProducerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/kafka")
public class KafkaController {
    private final ProducerService producerService;

    @Autowired
    public KafkaController(ProducerService producerService) {
        this.producerService = producerService;
    }

    @GetMapping(value = "/start")
    public String sendMessageToKafkaTopic() throws Exception {
        this.producerService.startReadingThread();
        return "started";
    }
}

