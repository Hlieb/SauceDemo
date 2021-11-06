package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductsPage extends BasePage{

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    private static final String ADD_PRODUCT_TO_CART_BUTTON = "//*[text()='%s']/ancestor::*[@class='inventory_item']//button";
    private static final String CART_URL = "https://www.saucedemo.com/cart.html";


    public ProductsPage addProductToCart(String productName) {
        WebElement addProductToCartButton = driver.findElement(By.xpath(String.format(ADD_PRODUCT_TO_CART_BUTTON, productName)));
        driver.findElement(By.xpath(String.format(ADD_PRODUCT_TO_CART_BUTTON, productName))).click();
        return this;
    }
    public ProductsPage openPage() {
        openPage(CART_URL);
        return this;
    }
}