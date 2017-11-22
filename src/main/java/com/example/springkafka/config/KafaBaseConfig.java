package com.example.springkafka.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafaBaseConfig {

	@Value("${kafka.bootstrap.servers}")
	protected String bootstrap_servers;
	
	@Value("${kafka.topic}")
	protected String topic;
	
	public String getTopic() {
		return topic;
	}
	
	

}
