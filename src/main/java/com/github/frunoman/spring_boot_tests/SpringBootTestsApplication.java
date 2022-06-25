package com.github.frunoman.spring_boot_tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.beans.factory.config.CustomScopeConfigurer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.*;
import org.springframework.context.support.SimpleThreadScope;

import java.net.MalformedURLException;
import java.net.URL;
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
    @Profile(value = "firefox")
    public WebDriver firefoxDriver() throws MalformedURLException {
        WebDriverManager.firefoxdriver().setup();
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserName","firefox");
        capabilities.setCapability("platformName","LINUX");

        RemoteWebDriver driver = new RemoteWebDriver(new URL("http://172.17.0.1:4675/wd/hub"),capabilities);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.manage().window().maximize();
        return driver;
    }

    @Bean
    @Scope("thread")
    @Profile(value = "chrome")
    public WebDriver chromeDriver() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("--remote-debugging-port="+(9000+new Random().nextInt(500)));
        ChromeDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        return driver;
    }
}
