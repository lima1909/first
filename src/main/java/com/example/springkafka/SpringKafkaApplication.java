package com.example.springkafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.core.KafkaTemplate;

@SpringBootApplication
public class SpringKafkaApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringKafkaApplication.class, args);
	}

	@Autowired
	private KafkaTemplate<String, Person> kafkaTemplate;
	
	@Override
	public void run(String... arg0) throws Exception {
		for (int i = 0; i < 100; i++) {
			kafkaTemplate.sendDefault("" + i, new Person(i, "F" + i, "S" + i));
		}
	}
}
