package com.packs.kafka.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.cassandra.config.SchemaAction;
import org.springframework.data.cassandra.repository.config.EnableCassandraRepositories;

@Configuration
@PropertySource("classpath:application.properties")
@EnableCassandraRepositories
public class CassandraConfig {
    @Value("spring.data.cassandra.port")
    private String contactPoints;

    @Value("9042")
    private int port;

    @Value("${spring.data.cassandra.keyspace-name}")
    private String keySpace;

    protected String getKeyspaceName() {
        return keySpace;
    }

    protected String getContactPoints() {
        return contactPoints;
    }

    protected int getPort() {
        return port;
    }

    public SchemaAction getSchemaAction() {
        return SchemaAction.CREATE_IF_NOT_EXISTS;
    }


}
