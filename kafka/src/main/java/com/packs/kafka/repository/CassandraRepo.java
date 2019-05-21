package com.packs.kafka.repository;


import com.packs.kafka.model.JobDetails;
import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;


public interface CassandraRepo extends CrudRepository<JobDetails, Long> {

//    @Query(value="SELECT * FROM jobposts WHERE id?0")
//    public Optional<JobDetails> findById(Long id);

    @AllowFiltering
    public List<JobDetails> findJobDetailsById(Long id);
}

