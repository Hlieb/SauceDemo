package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class CheckoutStepTwoPage extends BasePage {

    private static final By FINISH_BUTTON = By.xpath("//*[@id='finish']");
    private static final By CANCEL_BUTTON = By.xpath("//*[@id='cancel']");

    public CheckoutStepTwoPage(WebDriver driver) {
        super(driver);
    }

    @Step("Clicking button 'Cancel'")
    public ProductsPage clickCancelButton(){
        log.info("Clicking button 'Cancel'");
        driver.findElement(CANCEL_BUTTON).click();
        return new ProductsPage(driver);
    }

    @Step("Clicking button 'FINISH'")
    public CheckoutCompletePage clickFinishButton(){
        log.info("Clicking button 'FINISH'");
        driver.findElement(FINISH_BUTTON).click();
        return new CheckoutCompletePage(driver);
    }
}
