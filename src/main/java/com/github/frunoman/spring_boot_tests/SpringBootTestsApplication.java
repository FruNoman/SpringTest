package com.github.frunoman.spring_boot_tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.beans.factory.config.CustomScopeConfigurer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.context.support.SimpleThreadScope;

import java.time.Duration;
import java.util.Random;

@SpringBootApplication
public class SpringBootTestsApplication {


    public static void main(String[] args) {
        SpringApplication.run(SpringBootTestsApplication.class, args);
    }

    @Bean
    public CustomScopeConfigurer newCustomScopeConfigurer() {
        CustomScopeConfigurer configurer = new CustomScopeConfigurer();
        SimpleThreadScope threadScope = new SimpleThreadScope();
        configurer.addScope("thread", threadScope);
        return configurer;
    }

    @Bean
    @Primary
    @Scope("thread")
    public WebDriver firefoxDriver() {
        System.setProperty("webdriver.gecko.driver", this.getClass().getClassLoader().getResource("geckodriver").getPath());
        FirefoxDriver driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.manage().window().maximize();
        return driver;
    }

    @Bean
    @Scope("thread")
    public WebDriver chromeDriver() {
        System.setProperty("webdriver.chrome.driver", this.getClass().getClassLoader().getResource("chromedriver").getPath());
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("--remote-debugging-port="+(9000+new Random().nextInt(500)));
        ChromeDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        return driver;
    }
}
