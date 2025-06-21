package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ProductPage {

    WebDriver driver;
    WebDriverWait wait;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
    }

    // Dynamic selectors for any available size and color
    By sizeOption = By.cssSelector("div.swatch-attribute.size div.swatch-option");
    By colorOption = By.cssSelector("div.swatch-attribute.color div.swatch-option");
    By addToCartBtn = By.id("product-addtocart-button");
    By miniCartIcon = By.cssSelector("a.showcart");
    By productNameInCart = By.cssSelector(".product-item-name > a");

    public void selectSizeAndColor() {
        // Select first available size
        WebElement size = wait.until(ExpectedConditions.visibilityOfElementLocated(sizeOption));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", size);
        size.click();

        // Select first available color
        WebElement color = wait.until(ExpectedConditions.visibilityOfElementLocated(colorOption));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", color);
        color.click();
    }

    public void addToCart() {
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(addToCartBtn));
        button.click();
    }

    public void openMiniCart() {
        WebElement cartIcon = wait.until(ExpectedConditions.elementToBeClickable(miniCartIcon));
        cartIcon.click();
    }

    public String getProductNameFromCart() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(productNameInCart)).getText();
    }
}
