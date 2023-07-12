package com.github.frunoman.spring_boot_tests.pages;

import com.github.frunoman.spring_boot_tests.utils.Category;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Scope("webDriver")
public class MainPage extends BasePage {
    @FindBy(css = "ul.menu-categories_type_main>li>a")
    private List<WebElement> mainCategories;
    @FindBy(css = "fat-menu")
    private WebElement catalogButton;



    public void clickOnCategory(Category category) {
        waitForElements(mainCategories);
        mainCategories.stream().filter(a->a.getText().equals(category.toString())).findFirst().ifPresent(WebElement::click);
    }

}
