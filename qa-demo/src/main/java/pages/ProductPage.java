package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductPage {

    WebDriver driver;

    // Constructor
    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }
	

    // Locators
    By sizeOption = By.cssSelector("div.swatch-attribute.size div[option-label='M']");
    By colorOption = By.cssSelector("div.swatch-attribute.color div.swatch-option"); 
    By addToCartBtn = By.id("product-addtocart-button");
    By miniCartIcon = By.cssSelector("a.showcart");
    By productNameInCart = By.cssSelector(".product-item-name > a");

    // Actions
    public void selectSizeAndColor() {
        driver.findElement(sizeOption).click();
        driver.findElement(colorOption).click();
    }

    public void addToCart() {
        driver.findElement(addToCartBtn).click();
    }

    public void openMiniCart() {
        driver.findElement(miniCartIcon).click();
    }

    public String getProductNameFromCart() {
        return driver.findElement(productNameInCart).getText();
    }
}
