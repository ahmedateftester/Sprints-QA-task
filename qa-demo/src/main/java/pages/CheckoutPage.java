package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.time.Duration;
import java.util.List;

public class CheckoutPage {

    WebDriver driver;
    WebDriverWait wait;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public void fillShippingInfo() throws InterruptedException {
        // Step 1: Email
        WebElement emailField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("customer-email")));
        emailField.clear();
        emailField.sendKeys("guest@example.com");

        // Step 2: First and Last Name
        driver.findElement(By.name("firstname")).sendKeys("Ahmed");
        driver.findElement(By.name("lastname")).sendKeys("Tester");

        // Step 3: Address, City, Postcode, Phone
        driver.findElement(By.name("street[0]")).sendKeys("123 Test Street");
        driver.findElement(By.name("city")).sendKeys("Cairo");
        driver.findElement(By.name("postcode")).sendKeys("12345");
        driver.findElement(By.name("telephone")).sendKeys("01012345678");

        // Step 4: Country
        Select countryDropdown = new Select(driver.findElement(By.name("country_id")));
        countryDropdown.selectByVisibleText("Egypt");

        // Step 5: State/Region (if available)
        try {
            Select stateDropdown = new Select(driver.findElement(By.name("region_id")));
            stateDropdown.selectByIndex(1);
        } catch (NoSuchElementException e) {
            System.out.println("No state dropdown found, skipping...");
        }

        // Step 6: اختر طريقة الشحن "Best Way"
        WebElement bestWayRadio = wait.until(
            ExpectedConditions.elementToBeClickable(By.cssSelector("input[type='radio'][value='flatrate_flatrate']"))
        );
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", bestWayRadio);
        bestWayRadio.click();

        // Step 7: اضغط على Next
        WebElement nextButton = wait.until(
            ExpectedConditions.elementToBeClickable(By.cssSelector("button.continue"))
        );
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", nextButton);
        nextButton.click();

        Thread.sleep(2000); // انتظار بعد الضغط
    }
}
