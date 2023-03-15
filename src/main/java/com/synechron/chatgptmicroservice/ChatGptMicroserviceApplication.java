package com.synechron.chatgptmicroservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ChatGptMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ChatGptMicroserviceApplication.class, args);
	}

}
