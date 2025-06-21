package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class CheckoutPage {
    WebDriver driver;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    By proceedToCheckoutBtn = By.cssSelector("a[href*='checkout']");
    By emailField = By.id("customer-email");
    By firstName = By.name("firstname");
    By lastName = By.name("lastname");
    By street = By.name("street[0]");
    By city = By.name("city");
    By postcode = By.name("postcode");
    By phone = By.name("telephone");
    By country = By.name("country_id");
    By region = By.name("region_id");
    By continueBtn = By.cssSelector("button.continue");

    public void proceedToCheckout() {
        driver.findElement(proceedToCheckoutBtn).click();
    }

    public void fillShippingInfo() {
        driver.findElement(emailField).sendKeys("testuser@mail.com");
        driver.findElement(firstName).sendKeys("Test");
        driver.findElement(lastName).sendKeys("User");
        driver.findElement(street).sendKeys("123 Test St");
        driver.findElement(city).sendKeys("Cairo");
        driver.findElement(postcode).sendKeys("11311");
        driver.findElement(phone).sendKeys("01012345678");

        Select countrySelect = new Select(driver.findElement(country));
        countrySelect.selectByVisibleText("Egypt");

        Select regionSelect = new Select(driver.findElement(region));
        regionSelect.selectByIndex(1); // أي محافظة

        driver.findElement(continueBtn).click();
    }
}
