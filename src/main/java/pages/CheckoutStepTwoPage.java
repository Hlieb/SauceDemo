package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutStepTwoPage extends BasePage {

    private static final By FINISH_BUTTON = By.xpath("//*[@id='finish']");
    private static final By CANCEL_BUTTON = By.xpath("//*[@id='cancel']");

    public CheckoutStepTwoPage(WebDriver driver) {
        super(driver);
    }

    @Step("Clicking button 'Cancel'")
    public void clickCancelButton(){
        driver.findElement(CANCEL_BUTTON).click();
    }

    @Step("Clicking button 'FINISH'")
    public void clickFinishButton(){
        driver.findElement(FINISH_BUTTON).click();
    }
}
