package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutStepTwoPage extends CheckoutPage {


    private static final By FINISH_BUTTON = By.xpath("//*[@id='finish']");
    private static final By CANCEL_BUTTON = By.xpath("//*[@id='cancel']");

    public CheckoutStepTwoPage(WebDriver driver) {
        super(driver);
    }

    public void clickCancelButton(){
        driver.findElement(CANCEL_BUTTON).click();
    }

    public void clickFinishButton(){
        driver.findElement(FINISH_BUTTON).click();
    }
}
