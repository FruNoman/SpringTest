package com.github.frunoman.spring_boot_tests.configs;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.springframework.context.annotation.*;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Random;

@Configuration
public class RemoteWebDriverConfig {
    @Bean
    @Scope("thread")
    @Profile(value = "webDriver")
    public WebDriver remoteFirefoxDriver() throws MalformedURLException {
        WebDriverManager.firefoxdriver().setup();
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("browserName", "firefox");
        capabilities.setCapability("platformName", "LINUX");
        RemoteWebDriver driver = new RemoteWebDriver(new URL("http://172.17.0.1:4675/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.manage().window().maximize();
        return driver;
    }

    @Bean
    @Scope("thread")
    @Profile(value = "webDriver")
    public WebDriver remoteChromeDriver() throws MalformedURLException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox");
        options.addArguments("--remote-debugging-port=" + (9000 + new Random().nextInt(500)));
        options.setCapability("browserName", "chrome");
        options.setCapability("platformName", "LINUX");
        RemoteWebDriver driver = new RemoteWebDriver(new URL("http://172.17.0.1:4675/wd/hub"), options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        driver.manage().window().maximize();
        return driver;
    }
}
