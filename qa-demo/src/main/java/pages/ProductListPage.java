package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductListPage {

    WebDriver driver;

    // Constructor
    public ProductListPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    By firstProductLink = By.cssSelector(".product-item-info a.product-item-link");

    // Actions
    public void openFirstProduct() {
        driver.findElement(firstProductLink).click();
    }
}
