package tests;

import org.testng.annotations.Test;
import pages.ProductPage;
import pages.ProductListPage;

public class AddToCartTest extends BaseTest {

    @Test
    public void addHoodieToCartTest() throws InterruptedException {
        // Step 1: Go to product list page
        driver.get("https://magento.softwaretestingboard.com/men/tops-men/hoodies-and-sweatshirts-men.html");

        // Step 2: Open first product from list
        ProductListPage productList = new ProductListPage(driver);
        productList.openFirstProduct();

        // Step 3: Interact with product page
        ProductPage product = new ProductPage(driver);
        product.selectSizeAndColor();
        product.addToCart();

        // Step 4: Open mini cart
        Thread.sleep(3000);
        product.openMiniCart();
        Thread.sleep(2000);

        // Step 5: Assert product added
        String name = product.getProductNameFromCart();
        System.out.println("Product in cart: " + name);
        assert name.toLowerCase().contains("hoodie");
    }
}
