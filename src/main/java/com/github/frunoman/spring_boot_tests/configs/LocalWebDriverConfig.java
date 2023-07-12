package com.github.frunoman.spring_boot_tests.configs;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.springframework.context.annotation.*;

import java.time.Duration;
import java.util.Random;

@Configuration
public class LocalWebDriverConfig {
    @Bean
    @Scope("thread")
    @Profile(value = "localChrome")
    public WebDriver driver() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
//        options.setBinary("/usr/bin/google-chrome");
        options.addArguments("--no-sandbox");
//        options.addArguments("--disable-dev-shm-usage");
//        options.addArguments("--headless");

        options.addArguments("--remote-allow-origins=*");
        options.addArguments("--remote-debugging-port=" + (9000 + new Random().nextInt(500)));
        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        return driver;
    }

    @Bean
    @Primary
    @Scope("thread")
    @Profile(value = "localFirefox")
    public WebDriver firefoxDriver() {
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions options = new FirefoxOptions();
        options.setBinary("/usr/bin/firefox");
        WebDriver driver = new FirefoxDriver(options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.manage().window().maximize();
        return driver;
    }
}
