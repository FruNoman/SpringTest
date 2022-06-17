package com.github.frunoman.spring_boot_tests.pages;

import jakarta.annotation.PostConstruct;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public abstract class BasePage {
    @Autowired
    protected WebDriver driver;

    @PostConstruct
    private void init() {
        PageFactory.initElements(this.driver, this);
    }
}
