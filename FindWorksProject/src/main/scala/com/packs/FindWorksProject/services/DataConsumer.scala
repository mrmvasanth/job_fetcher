package com.packs.FindWorksProject.services
import org.slf4j.LoggerFactory
import java.util.concurrent.CountDownLatch
import org.springframework.kafka.annotation.KafkaListener

class DataConsumer {
  private val LOGGER = LoggerFactory.getLogger(classOf[DataProducer])

  private val latch = new CountDownLatch(1)

  def getLatch: CountDownLatch = latch


  @KafkaListener(topics = Array("helloworld")) def receive(payload: String): Unit = {
    LOGGER.info("received payload='{}'", payload)
    latch.countDown
  }
}
