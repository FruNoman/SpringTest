package com.github.frunoman.spring_boot_tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;

@SpringBootTest
public class SpringBootTestsTest {

	@Bean
	public WebDriver webDriver() {
		System.setProperty("webdriver.gecko.driver", this.getClass().getClassLoader().getResource("geckodriver").getPath());
		return new FirefoxDriver();
	}



	public static void main(String[] args) {
		SpringApplication.run(SpringBootTestsTest.class, args);
	}

}
