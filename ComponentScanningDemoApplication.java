package com.component.scanning.ComponentScanningDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(
		scanBasePackages= {"Demo"}
)
public class ComponentScanningDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ComponentScanningDemoApplication.class, args);
	}

}
