package com.github.frunoman.spring_boot_tests.tests;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

@SpringBootTest
public class BaseTest extends AbstractTestNGSpringContextTests {

    @Autowired
    protected WebDriver driver;

    @BeforeMethod
    public void beforeMethod() {
        driver.get("https://rozetka.com.ua/ua/");
    }

    @AfterMethod
    public void afterMethod() {
        if (driver != null) {
            driver.quit();
        }
    }
}
