package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;
import pages.ProductListPage;
import pages.ProductPage;
import pages.CheckoutPage;

import java.time.Duration;
import java.util.List;

public class CheckoutTest extends BaseTest {

    @Test
    public void testGuestCheckoutFlow() throws InterruptedException {
        // Step 1: افتح صفحة الكاتيجوري
        driver.get("https://magento.softwaretestingboard.com/men/tops-men/hoodies-and-sweatshirts-men.html");

        // Step 2: اضغط على أول منتج
        ProductListPage productList = new ProductListPage(driver);
        productList.openFirstProduct();

        // Step 3: اختار المقاس واللون وأضف للسلة
        ProductPage product = new ProductPage(driver);
        product.selectSizeAndColor();
        product.addToCart();

        // Step 4: افتح صفحة الكارت مباشرة
        driver.get("https://magento.softwaretestingboard.com/checkout/cart/");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        // Optional: تأكد أن في منتجات في السلة
        List<WebElement> itemsInCart = driver.findElements(By.cssSelector(".cart.item"));
        System.out.println("Items in cart: " + itemsInCart.size());
        assert itemsInCart.size() > 0 : "❌ Cart is empty!";

        // Step 5: Scroll واضغط على "Proceed to Checkout" باستخدام XPath
        WebElement checkoutBtn = wait.until(
            ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Proceed to Checkout']"))
        );
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", checkoutBtn);
        checkoutBtn.click();
        Thread.sleep(1000); // انتظار بعد الضغط

        // Step 6: تأكد من الوصول لصفحة الشراء
        wait.until(ExpectedConditions.urlContains("checkout"));
        System.out.println("Moved to Checkout: " + driver.getCurrentUrl());

        // Step 7: املأ بيانات الشحن
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("customer-email")));
        CheckoutPage checkout = new CheckoutPage(driver);
        checkout.fillShippingInfo();

        System.out.println("✅ Guest checkout flow test completed.");
    }
}
