package com.github.frunoman.spring_boot_tests.tests;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends BaseTest {


    @Autowired
    protected WebDriver driver;

    @BeforeMethod
    public void beforeMethod() {
        driver.get("https://rozetka.com.ua/ua/");
    }

    @Test
    public void baseLoginTest() {
        System.out.println("do");
    }
}
