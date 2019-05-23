package com.packs.kafka.model;

import com.datastax.driver.core.utils.UUIDs;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.sql.Timestamp;
import java.util.UUID;


@Table("job_post_details")
public class JobDetails {

    @PrimaryKey
    private UUID id;

    private Timestamp timestamp;

    private int jobsCount;

    public JobDetails(){}

    public JobDetails(UUID id, Timestamp timestamp, int jobsCount) {
        this.id = id;
        this.timestamp = timestamp;
        this.jobsCount = jobsCount;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public int getJobsCount() {
        return jobsCount;
    }

    public void setJobsCount(int jobsCount) {
        this.jobsCount = jobsCount;
    }
}
