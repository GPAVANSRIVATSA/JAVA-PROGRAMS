package com.SpringAPI.ApiIllustrationWebClient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;


@SpringBootApplication
public class ApiIllustrationWebClientApplication {

	@Bean
	public WebClient.Builder getWebClientBuilder()
	{
		return WebClient.builder();
	}
	public static void main(String[] args) {
		SpringApplication.run(ApiIllustrationWebClientApplication.class, args);
	}

}
