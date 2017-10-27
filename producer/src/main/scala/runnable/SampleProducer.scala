package runnable

import java.util.Properties

import org.apache.kafka.clients.producer.{KafkaProducer, Producer, ProducerRecord}

object SampleProducer extends App {

  val props = new Properties()
  props.put("bootstrap.servers", "localhost:9092")
  props.put("acks", "all")
  props.put("retries", "0")
  props.put("batch.size", "16384")
  props.put("linges.ms", "1")
  props.put("buffer.memory", "33554432")
  props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer")
  props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer")

  val producer: Producer[String, String] = new KafkaProducer[String, String](props)

  val range = 0 to 100
  range map { i =>
    val message = new ProducerRecord[String, String]("my-topic", s"Sample message $i")
    producer.send(message)
    println(s"Send message $i")
  }

  producer.close()
}