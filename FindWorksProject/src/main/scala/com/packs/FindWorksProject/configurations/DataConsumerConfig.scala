package com.packs.FindWorksProject.configurations

import org.apache.kafka.common.serialization.StringDeserializer
import org.springframework.beans.factory.annotation.Value

class DataConsumerConfig {

  @Value("${kafka.bootstrap-servers}") private val bootstrapServers = null

  import java.util

  import org.apache.kafka.clients.consumer.ConsumerConfig
  import org.springframework.context.annotation.Bean
  import org.springframework.kafka.config.{ConcurrentKafkaListenerContainerFactory, KafkaListenerContainerFactory}
  import org.springframework.kafka.core.DefaultKafkaConsumerFactory
  import org.springframework.kafka.listener.ConcurrentMessageListenerContainer

  @Bean def consumerConfigs: util.Map[String, AnyRef] = {
    val props = new util.HashMap[String, AnyRef]
    // list of host:port pairs used for establishing the initial connections to the Kafka cluster
    props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers)
    props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, classOf[StringDeserializer])
    props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, classOf[StringDeserializer])
    // allows a pool of processes to divide the work of consuming and processing records
    props.put(ConsumerConfig.GROUP_ID_CONFIG, "topic1")
    // automatically reset the offset to the earliest offset
    props.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest")
    props
  }

  @Bean def consumerFactory = new DefaultKafkaConsumerFactory[String, String](consumerConfigs)

  @Bean def kafkaListenerContainerFactory: KafkaListenerContainerFactory[ConcurrentMessageListenerContainer[String, String]] = {
    val factory = new ConcurrentKafkaListenerContainerFactory[String, String]
    factory.setConsumerFactory(consumerFactory)
    factory
  }
}
