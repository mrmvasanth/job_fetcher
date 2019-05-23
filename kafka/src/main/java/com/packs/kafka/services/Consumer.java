package com.packs.kafka.services;
import com.packs.kafka.model.JobDetails;
import com.packs.kafka.repository.CassandraRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.sql.Timestamp;
import java.util.UUID;

import static com.packs.kafka.config.Constants.LISTEN_GROUP_ID;
import static com.packs.kafka.config.Constants.LISTEN_TOPIC;

@Service
public class Consumer {

    @Autowired
    CassandraRepo cassandraRepo;

    private final Logger logger = LoggerFactory.getLogger(Consumer.class);
    @KafkaListener(topics = LISTEN_TOPIC, groupId = LISTEN_GROUP_ID)

    public void consume(String jobsCount){
        System.out.println("Consumed:"+jobsCount);
        insertIntoCassandra(Integer.parseInt(jobsCount));
        logger.info(String.format("$$ -> Consumed Message -> %s",jobsCount));

    }

    public void insertIntoCassandra(int jobsCount) {
//        clearData ();
        saveData(jobsCount);
    }

    public void clearData(){
        cassandraRepo.deleteAll();
    }

    public void saveData(int jobsCount){
        Date date= new Date();
        long time = date.getTime();
        Timestamp timestamp=new Timestamp(time);
        JobDetails job=new JobDetails(UUID.randomUUID(),timestamp,jobsCount);

        cassandraRepo.save(job);

    }
}