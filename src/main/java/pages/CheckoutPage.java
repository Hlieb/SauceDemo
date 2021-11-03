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
    private static final By CHECKOUT_ERROR_BUTTON = By.xpath("//*[@data-test='error']");


    public void clickContinueButton() {
        driver.findElement(CONTINUE_BUTTON).click();
    }

    public void fillField(String firstName, String secondName, String postCode){
        driver.findElement(FIELD_FIRST_NAME).sendKeys(firstName);
        driver.findElement(FIELD_LAST_NAME).sendKeys(secondName);
        driver.findElement(FIELD_POSTAL_CODE).sendKeys(postCode);
    }

    public void checkOutOnlyWithFirstName(String firstName) {
        driver.findElement(FIELD_FIRST_NAME).sendKeys(firstName);
        driver.findElement(CONTINUE_BUTTON).click();
    }

    public String getCheckoutErrorText() {
        return driver.findElement(CHECKOUT_ERROR_BUTTON).getText();
    }
}
