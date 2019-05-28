package com.packs.FindWorksProject.configurations


import org.apache.kafka.common.serialization.StringSerializer
import org.springframework.context.annotation.Configuration

@Configuration
class DataProducerConfig {

  import java.util

  import org.apache.kafka.clients.producer.ProducerConfig
  import org.springframework.beans.factory.annotation.Value
  import org.springframework.context.annotation.Bean
  import org.springframework.kafka.core.{DefaultKafkaProducerFactory, KafkaTemplate}

  @Value("${kafka.bootstrap-servers}") private val bootstrapServers :String = null


  @Bean def producerConfigs: util.Map[String, AnyRef] = {
    val props = new util.HashMap[String, AnyRef]
    // list of host:port pairs used for establishing the initial connections to the Kakfa cluster
    props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers)
    props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, classOf[StringSerializer])
    props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, classOf[StringSerializer])
    props
  }

  @Bean def producerFactory = new DefaultKafkaProducerFactory[String, String](producerConfigs)

  @Bean def kafkaTemplate = new KafkaTemplate[String, String](producerFactory)

}
