package pages;

import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class CheckoutPage extends BasePage {

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    private static final By FIELD_FIRST_NAME = By.xpath("//*[@id='first-name']");
    private static final By FIELD_LAST_NAME = By.xpath("//*[@id='last-name']");
    private static final By FIELD_POSTAL_CODE = By.xpath("//*[@id='postal-code']");
    private static final By CONTINUE_BUTTON = By.xpath("//*[@id='continue']");
    private static final By CHECKOUT_ERROR_BUTTON = By.xpath("//*[@data-test='error']");

    @Step("Clicking button continue")
    public  CheckoutStepTwoPage clickContinueButton() {
        log.info("Clicking button 'Continue'");
        driver.findElement(CONTINUE_BUTTON).click();
        return new CheckoutStepTwoPage(driver);
    }

    @Step("Filling fields: FirstName: '{firstName}' + LastName: '{secondName}' + Postcode: '{postcode}'")
    public CheckoutPage fillField(String firstName, String secondName, String postCode) {
        log.info("Filling field First name:" + firstName);
        driver.findElement(FIELD_FIRST_NAME).sendKeys(firstName);
        log.info("Filling field Last name:" + secondName);
        driver.findElement(FIELD_LAST_NAME).sendKeys(secondName);
        log.info("Filling field Postal code:" + postCode);
        driver.findElement(FIELD_POSTAL_CODE).sendKeys(postCode);
        return this;
    }

    @Step("Filling FirstName field: '{firstName}'")
    public void checkOutOnlyWithFirstName(String firstName) {
        log.info("Filling only field First name:" + firstName);
        driver.findElement(FIELD_FIRST_NAME).sendKeys(firstName);
    }

    public String getCheckoutErrorText() {
        return driver.findElement(CHECKOUT_ERROR_BUTTON).getText();
    }
}