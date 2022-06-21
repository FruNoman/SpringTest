package com.github.frunoman.spring_boot_tests.tests;

import com.github.frunoman.spring_boot_tests.pages.MainPage;
import com.github.frunoman.spring_boot_tests.utils.Categories;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

@SpringBootTest
public class BaseTest extends AbstractTestNGSpringContextTests {

    @Autowired
    protected WebDriver driver;

    @Autowired
    protected MainPage mainPage;

    @BeforeMethod
    public void beforeMethod() {
        driver.get("https://rozetka.com.ua/ua/");
    }

    @Test
    public void baseLoginTest() throws InterruptedException {
        mainPage.clickOnCategory(Categories.SMARTPHONES_AND_TV);
        System.out.println("some");
        Thread.sleep(10000);
    }

    @AfterMethod
    public void afterMethod() {
        if (driver != null) {
            driver.quit();
        }
    }
}
