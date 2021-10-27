package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {

    public CartPage(WebDriver driver) {
        super(driver);
    }

    private static final String PRODUCT_PRICE = "//*[text()='%s']/ancestor::*[@class='cart_item']//*[@class='inventory_item_price']";
    private static final By CHECK_OUT_BUTTON = By.xpath("//*[@id='checkout']");
    private static final By CHANGE_QUANTITY_FIELD = By.xpath("//*[@class='cart_quantity']");


    public String getProductPrice(String productName) {
        return driver.findElement(By.xpath(String.format(PRODUCT_PRICE, productName))).getText();
    }

    public void checkOut() {
        driver.findElement(CHECK_OUT_BUTTON).click();
    }

    public void changeQuantity(String quantity) {
        driver.findElement(CHANGE_QUANTITY_FIELD).sendKeys(quantity);
    }

    public String getQuantity() {
        return driver.findElement(CHANGE_QUANTITY_FIELD).getText();

    }
}
