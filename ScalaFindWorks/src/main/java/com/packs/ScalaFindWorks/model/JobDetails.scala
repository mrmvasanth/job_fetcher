package com.packs.ScalaFindWorks.model

import java.sql.Timestamp
import java.util.UUID
import org.springframework.data.cassandra.core.mapping.{PrimaryKey, Table}
import scala.beans.BeanProperty

@Table("job_post_details")
class JobDetails {
  @PrimaryKey
  @BeanProperty
  var id: UUID =

  @BeanProperty
  var timestamp: Timestamp

  @BeanProperty
  var jobsCount: Int =

  def this(id: UUID, timestamp: Timestamp, jobsCount: Int) = {
    this()
    this.id = id
    this.timestamp = timestamp
    this.jobsCount = jobsCount
  }

}
