package com.vkeline.webJpaDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan("com.vkeline.webJpaDemo.config.druidConfig")
public class WebJpaDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebJpaDemoApplication.class, args);
	}
}
