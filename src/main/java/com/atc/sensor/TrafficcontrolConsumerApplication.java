package com.atc.sensor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class TrafficcontrolConsumerApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrafficcontrolConsumerApplication.class, args);
	}

}
