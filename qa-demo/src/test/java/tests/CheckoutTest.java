package tests;

import org.testng.annotations.Test;
import pages.ProductListPage;
import pages.ProductPage;
import pages.CheckoutPage;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;
import org.openqa.selenium.By;

public class CheckoutTest extends BaseTest {

    @Test
    public void testGuestCheckoutFlow() throws InterruptedException {
        driver.get("https://magento.softwaretestingboard.com/men/tops-men/hoodies-and-sweatshirts-men.html");

        // اختار منتج
        ProductListPage productList = new ProductListPage(driver);
        productList.openFirstProduct();

        // إضافة للعربة
        ProductPage product = new ProductPage(driver);
        product.selectSizeAndColor();
        product.addToCart();

        Thread.sleep(2000); // انتظار تأكيد الإضافة

        product.openMiniCart();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[href*='checkout/cart']"))).click();

        // تابع للـ Checkout
        CheckoutPage checkout = new CheckoutPage(driver);
        checkout.proceedToCheckout();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("customer-email")));
        checkout.fillShippingInfo();

        System.out.println("Checkout info filled successfully ✅");
    }
}
