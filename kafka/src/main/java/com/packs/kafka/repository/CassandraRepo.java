package com.packs.kafka.repository;

import com.packs.kafka.model.JobDetails;
import org.springframework.data.repository.CrudRepository;

public interface CassandraRepo extends CrudRepository<JobDetails, Long> {
}

