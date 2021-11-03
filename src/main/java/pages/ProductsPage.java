package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductsPage extends BasePage{

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    private static final String ADD_PRODUCT_TO_CART_BUTTON = "//*[text()='%s']/ancestor::*[@class='inventory_item']//button";
    private static final String PRODUCTS_URL = "/inventory.html";
    private static final String CART_URL = "/cart.html";

    public ProductsPage addProductToCart(String productName) {
        waitForElementLocated(driver.findElement(By.xpath(String.format(ADD_PRODUCT_TO_CART_BUTTON, productName))), 10);
        WebElement addProductToCartButton = driver.findElement(By.xpath(String.format(ADD_PRODUCT_TO_CART_BUTTON, productName)));
        addProductToCartButton.click();
        return this;
    }

    public ProductsPage openPage() {
        openPage(BASE_URL + CART_URL);
        return new ProductsPage(driver);
    }
}