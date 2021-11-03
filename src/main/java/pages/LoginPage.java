package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

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




    public void login(String username, String password) {
        driver.findElement(USERNAME_INPUT).sendKeys(username);
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
        driver.findElement(LOGIN_BUTTON).click();
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

    public void waitForOpenPage() {
        waitForElementLocated(BOT_LOGO, 10);
    }

    public LoginPage waitForPageOpened() {
        openPage(BASE_URL);
        return this;
    }

}