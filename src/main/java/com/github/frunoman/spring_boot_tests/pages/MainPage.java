package com.github.frunoman.spring_boot_tests.pages;

import com.github.frunoman.spring_boot_tests.utils.Categories;
import com.github.frunoman.spring_boot_tests.utils.SubCategories;
import com.github.frunoman.spring_boot_tests.utils.SubCategoriesHeaders;
import jakarta.annotation.PostConstruct;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Lazy
public class MainPage extends BasePage {
    @FindBy(css = "ul.menu-categories_type_main>li>a")
    private List<WebElement> mainCategories;
    @FindBy(css = "li.f-menu-sub-l-i>a")
    private List<WebElement> subCategories;
    @FindBy(css = ".f-menu-sub>a")
    private List<WebElement> subCategoriesHeaders;


    public void hoverOnCategory(Categories category) {
        waitForElements(mainCategories);
        for (WebElement element : mainCategories) {
            if (element.getText().equals(category.toString())) {
                Actions actions = new Actions(driver);
                actions.moveToElement(element).build().perform();
                break;
            }
        }
    }

    public void clickOnCategory(Categories category) {
        waitForElements(mainCategories);
        for (WebElement element : mainCategories) {
            if (element.getText().equals(category.toString())) {
                element.click();
                break;
            }
        }
    }

    public void clickOnSubCategory(SubCategories subCategory) {
        waitForElements(subCategories);
        for (WebElement element : subCategories) {
            if ((element.getText()).trim().equals(subCategory.toString())) {
                element.click();
                break;
            }
        }
    }

    public void clickOnSubCategoryHeader(SubCategoriesHeaders subCategoryheader) {
        waitForElements(subCategoriesHeaders);
        for (WebElement element : subCategoriesHeaders) {
            if ((element.getText()).trim().equals(subCategoryheader.toString())) {
                element.click();
                break;
            }
        }
    }
}
