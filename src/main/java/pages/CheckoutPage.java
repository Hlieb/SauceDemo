package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends ProductsPage {

    public CheckoutPage(WebDriver driver) {
        super(driver);

    }

    private static final By FIELD_FIRST_NAME = By.xpath("//*[@id='first-name']");
    private static final By FIELD_LAST_NAME = By.xpath("//*[@id='last-name']");
    private static final By FIELD_POSTAL_CODE = By.xpath("//*[@id='postal-code']");
    private static final By CONTINUE_BUTTON = By.xpath("//*[@id='continue']");


    public void checkout() {
        driver.findElement(FIELD_FIRST_NAME).sendKeys("GLIEB");
        driver.findElement(FIELD_LAST_NAME).sendKeys("BOIECHKO");
        driver.findElement(FIELD_POSTAL_CODE).sendKeys("5555");
        driver.findElement(CONTINUE_BUTTON).click();
    }
}
