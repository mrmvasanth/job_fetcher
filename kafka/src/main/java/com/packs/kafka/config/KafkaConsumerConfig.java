package com.packs.kafka.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.validation.Valid;
import java.util.HashMap;

@Configuration
@PropertySource("classpath:application.yml")
public class KafkaConsumerConfig {

    @Value("${bootstrap-servers}")
    private String bootstrapServers;

    @Value("${group-id}")
    private String groupId;

    @Value("${auto-offset-reset}")
    private String autoOffsetReset;


    @Bean
    public HashMap<String, Object> kafkaConsumerConf() {

        HashMap<String, Object> config = new HashMap();
        config.put("bootstrap.servers", bootstrapServers);
        config.put("group.id", groupId);
        config.put("auto-offset-reset",autoOffsetReset);
        return config;
    }
}