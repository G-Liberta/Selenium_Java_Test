package com.deloitte.selenium;

import org.springframework.boot.SpringApplication;

public class TestSeleniumApplication {

	public static void main(String[] args) {
		SpringApplication.from(SeleniumApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
