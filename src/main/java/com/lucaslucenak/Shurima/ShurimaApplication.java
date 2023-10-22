package com.lucaslucenak.Shurima;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.locks.ReadWriteLock;

@SpringBootApplication
public class ShurimaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShurimaApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
