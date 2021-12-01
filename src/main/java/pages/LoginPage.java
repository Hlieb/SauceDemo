package pages;

import com.sun.org.apache.xerces.internal.impl.xpath.XPath;
import io.qameta.allure.Step;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

@Log4j2
public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    private static final By USERNAME_INPUT = By.xpath("//*[@id='user-name']");
    private static final By PASSWORD_INPUT = By.xpath("//*[@id='password']");
    private static final By LOGIN_BUTTON = By.xpath("//*[@id='login-button']");
    private static final By BOT_LOGO = By.xpath("//*[@class='bot_column']");
    private static final By LOGIN_ERROR = By.xpath("//*[text()='Epic sadface: Username and password do not match any user in this service']");
    private static final By INCORRECT_USERNAME = By.xpath("//*[text()='Epic sadface: Username is required']");
    private static final By INCORRECT_PASSWORD = By.xpath("//*[text()='Epic sadface: Password is required']");
    private static final String BASE_URL = "https://www.saucedemo.com/";



    @Step("Login as username: '{username}' with password: '{password}'")
    public ProductsPage login(String username, String password) {
        log.info(String.format("Send keys into 'username' field: " + username));
        driver.findElement(USERNAME_INPUT).sendKeys(username);
        log.info(String.format("Send keys into 'password' field: " + password));
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
        log.info("Click 'Login' button");
        driver.findElement(LOGIN_BUTTON).click();
        return new ProductsPage(driver);
    }


    public LoginPage openPage() {
        openPage(BASE_URL);
        waitForPageLoaded();
        return this;
    }

    public String getIncorrectLoginText() {
      return driver.findElement(LOGIN_ERROR).getText();
    }

    public String getIncorrectUsername() {
        return driver.findElement(INCORRECT_USERNAME).getText();
    }

    public String getIncorrectPassword() {
        return driver.findElement(INCORRECT_PASSWORD).getText();
    }

    public LoginPage waitForPageOpened() {
        openPage(BASE_URL);
        return this;
    }
}