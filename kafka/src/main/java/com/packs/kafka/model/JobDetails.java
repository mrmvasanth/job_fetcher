package com.packs.kafka.model;

import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;


@Table("jobposts")
public class JobDetails {

    @PrimaryKey
    private Long id;

    private String joblink;

    private String jobposition;

    public JobDetails(){}

    public JobDetails(Long id, String joblink, String jobposition) {
        this.id = id;
        this.joblink = joblink;
        this.jobposition = jobposition;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getJoblink() {
        return joblink;
    }

    public void setJoblink(String joblink) {
        this.joblink = joblink;
    }

    public String getJobposition() {
        return jobposition;
    }

    public void setJobposition(String jobposition) {
        this.jobposition = jobposition;
    }
}
