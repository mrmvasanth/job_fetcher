package com.packs.kafka.services;


import com.packs.kafka.model.JobDetails;
import com.packs.kafka.repository.CassandraRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class Producer{
    private static final Logger logger = LoggerFactory.getLogger(Producer.class);
    private static final String TOPIC = "topic1";

    @Autowired
    CassandraRepo cassandraRepo;

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void sendMessage(String message) {
        logger.info(String.format("$$ -> Producing message --> %s", message));
        this.kafkaTemplate.send(TOPIC, message);
        insertIntoCassandra();
    }

    public void insertIntoCassandra() {
        //clearData ();
        saveData();
    }

    public void clearData(){
        cassandraRepo.deleteAll();
    }

    public void saveData(){
        JobDetails job1=new JobDetails((long) 1,"www.link1.com","Engineer");
        JobDetails job2=new JobDetails((long) 2,"www.link2.com","Doctor");
        JobDetails job3=new JobDetails((long) 3,"www.link3.com","Lawyer");

        cassandraRepo.save(job1);
        cassandraRepo.save(job2);
        cassandraRepo.save(job3);

    }


}