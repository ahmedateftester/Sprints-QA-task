package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import pages.HomePage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePageTest extends BaseTest {

    @Test
    public void testSearchFunctionality() {
        HomePage home = new HomePage(driver);
        home.searchFor("hoodie");

        // انتظار لظهور أول منتج
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement firstProduct = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".product-item-info"))
        );

        // Scroll down to the first product
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", firstProduct);

        // تحقق من وجود منتجات
        String title = home.getTitle();
        System.out.println("Page Title: " + title);
        assert title.toLowerCase().contains("hoodie");
    }
}
