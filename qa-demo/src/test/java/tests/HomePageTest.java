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

        // انتظار أول منتج فعلي
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement firstProduct = wait.until(
                ExpectedConditions.visibilityOfElementLocated(By.cssSelector("li.product-item"))
        );

        // Scroll للمنتج عشان يظهر
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", firstProduct);

        // طباعة اسم المنتج للتأكيد
        String productName = firstProduct.findElement(By.cssSelector("a.product-item-link")).getText();
        System.out.println("First product: " + productName);

        assert !productName.isEmpty();  // تأكيد أن في منتج فعلي ظهر
    }
}
