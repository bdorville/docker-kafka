package runnable

import java.util.Properties

import org.apache.kafka.clients.consumer.{Consumer, ConsumerRecords, KafkaConsumer}

import scala.collection.convert.ImplicitConversions._

object SampleConsumer extends App {

  val props = new Properties()
  props.put("bootstrap.servers", "localhost:9092")
  props.put("group.id", "test")
  props.put("enable.auto.commit", "true")
  props.put("auto.commit.interval.ms", "1000")
  props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer")
  props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer")
  
  val consumer: Consumer[String, String] = new KafkaConsumer[String, String](props)
  consumer.subscribe(Seq("my-topic"))

  while(true) {
    val records: ConsumerRecords[String, String] = consumer.poll(100)
    records.foreach { record =>
      println(s"offset = ${record.offset()}, key = ${record.key()}, value = ${record.value()}")
    }
  }
}