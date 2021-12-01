package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

@Log4j2
public class ProductsPage extends BasePage {

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    private static final String ADD_PRODUCT_TO_CART_BUTTON = "//*[text()='%s']/ancestor::*[@class='inventory_item']//button";
    private static final String PRODUCTS_URL = "/inventory.html";
    private static final String CART_URL = "/cart.html";

    @Step("Adding product '{productName}' to the cart")
    public ProductsPage addProductToCart(String productName) {
        waitForElementLocated(driver.findElement(By.xpath(String.format(ADD_PRODUCT_TO_CART_BUTTON, productName))), 10);
        log.info("Finding button 'Add Product to Cart'");
        WebElement addProductToCartButton = driver.findElement(By.xpath(String.format(ADD_PRODUCT_TO_CART_BUTTON, productName)));
        log.info("Clicking at the button 'Add Product to Cart'");
        addProductToCartButton.click();
        return this;
    }

    public ProductsPage openPage() {
        openPage(CART_URL);
        return this;
    }
}