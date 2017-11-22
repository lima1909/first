package com.example.springkafka.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import com.example.springkafka.Person;
import com.example.springkafka.SpringKafkaListener;

@Configuration
public class KafkaConsumerConfig extends KafaBaseConfig{
	
	@Value("${kafka.group.id}")
	protected String group_id;


	@Bean
	public ConsumerFactory<String, Person> consumerFactory() {
		Map<String, Object> props = new HashMap<>();
		props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrap_servers);
		props.put(ConsumerConfig.GROUP_ID_CONFIG, group_id);
//		props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
//		props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		return new DefaultKafkaConsumerFactory<>(props, new StringDeserializer(), new JsonDeserializer<>(Person.class));
	}

	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, Person> kafkaListenerContainerFactory() {
		ConcurrentKafkaListenerContainerFactory<String, Person> factory = new ConcurrentKafkaListenerContainerFactory<>();
		factory.setConsumerFactory(consumerFactory());
		return factory;
	}
	
	@Bean
	public SpringKafkaListener listener1() {
		return new SpringKafkaListener();
	}

	@Bean
	public SpringKafkaListener listener2() {
		return new SpringKafkaListener();
	}

}
