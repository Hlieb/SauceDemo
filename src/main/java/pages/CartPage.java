package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class CartPage extends BasePage {

    public CartPage(WebDriver driver) {
        super(driver);
    }

    private static final By CHECKOUT_BUTTON = By.xpath("//*[@id='checkout']");
    private static final String CART_URL = "/cart.html";
    private static final String PRODUCT_PRICE = "//*[text()='%s']/ancestor::*[@class='cart_item']//*[@class='inventory_item_price']";

    public String getProductPrice(String productName) {
        log.info("Get price for product" + productName);
        return driver.findElement(By.xpath(String.format(PRODUCT_PRICE, productName))).getText();
    }

    @Step ("Clicking button 'Checkout'")
    public CheckoutPage clickCheckOutButton() {
        log.info("Clicking button 'Checkout'");
        driver.findElement(CHECKOUT_BUTTON).click();
        return new CheckoutPage(driver);
    }

    public CartPage openPage() {
        log.info("Opening page: " + BASE_URL + CART_URL);
        openPage(BASE_URL + CART_URL);
        waitForPageLoaded();
        return this; 
    }
}