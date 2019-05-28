package com.packs.FindWorksProject.services

import com.packs.FindWorksProject.constants.ConstantsUtil
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Service

@Service
class DataProducer{
  private val LOGGER = LoggerFactory.getLogger(classOf[DataProducer]);

  @Autowired
  private var kafkaTemplate: KafkaTemplate[String, String] = _

  def startProducer():Unit={
    LOGGER.info("sending payload='{}'")
    kafkaTemplate.send(ConstantsUtil.TARGET_TOPIC, "payload")

  }
}
