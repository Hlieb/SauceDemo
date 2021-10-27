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

    public void login(String username, String password) {
        driver.findElement(USERNAME_INPUT).sendKeys(username);
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
        driver.findElement(LOGIN_BUTTON).click();
    }

    public String incorrectLoginData() {
        return driver.findElement(By.xpath("//*[text()='Epic sadface: Username and password do not match any user in this service']")).getText();
    }

    public String incorrectUsername() {
        return driver.findElement(By.xpath("//*[text()='Epic sadface: Username is required']")).getText();
    }

    public String incorrectPassword() {
        return driver.findElement(By.xpath("//*[text()='Epic sadface: Password is required']")).getText();
    }
}