package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutCompletePage extends CheckoutStepTwoPage {
    public CheckoutCompletePage(WebDriver driver) {
        super(driver);
    }

    private static final By CHECKOUT_COMPLETE = By.xpath("//*[text()='Checkout: Complete!']");

    public String getFinalCheckOutText() {
        return driver.findElement(CHECKOUT_COMPLETE).getText();
    }
}
