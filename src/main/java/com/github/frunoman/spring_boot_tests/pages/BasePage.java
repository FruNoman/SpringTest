package com.github.frunoman.spring_boot_tests.pages;

import jakarta.annotation.PostConstruct;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.List;

public abstract class BasePage {
    @Autowired
    protected WebDriver driver;

    @PostConstruct
    private void init() {
        PageFactory.initElements(this.driver, this);
    }

    public void waitForElement(WebElement element) {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForElementStaleness(WebElement element) {
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.stalenessOf(element));
    }

    public void waitForElementIsClickable(WebElement element){
        new WebDriverWait(driver,Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitForElements(List<WebElement> elements){
        new WebDriverWait(driver,Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfAllElements(elements));
    }

}
