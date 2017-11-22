package com.example.springkafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;

public class SpringKafkaListener {

	@KafkaListener(topics = "${kafka.topic}", group = "${kafka.group.id}")
	public void listen(ConsumerRecord<String, Person> record) {
		System.err.println(record.value()
				+ " [KEY: " + record.key() 
				+ "] [partition: " + record.partition() 
				+ "] [Topic: " + record.topic()
				+ "] [Offset: " + record.offset() + "]");
	}

	
}
