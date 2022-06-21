package com.github.frunoman.spring_boot_tests.tests;

import com.github.frunoman.spring_boot_tests.pages.MainPage;
import com.github.frunoman.spring_boot_tests.utils.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest{
    @Autowired
    protected MainPage mainPage;

    @Test
    public void baseLoginTest() throws InterruptedException {
        mainPage.clickOnCategory(Category.SMARTPHONES_AND_TV);
        Thread.sleep(5000);
    }
}
