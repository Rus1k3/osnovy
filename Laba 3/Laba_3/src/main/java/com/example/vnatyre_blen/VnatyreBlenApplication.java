package com.example.vnatyre_blen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.example.vnatyre_blen")
public class VnatyreBlenApplication {

	public static void main(String[] args) {
		SpringApplication.run(VnatyreBlenApplication.class, args);
	}

}
