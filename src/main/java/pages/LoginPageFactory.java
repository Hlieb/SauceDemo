package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageFactory extends BasePage {
    public LoginPageFactory(WebDriver driver) {
        super(driver);
    }


    @FindBy(xpath = "//*[@id='user-name']")
    WebElement userNameInput;
    @FindBy(xpath = "//*[@id='password']")
    WebElement passwordInput;
    @FindBy(xpath = "//*[@id='login-button']")
    WebElement loginButton;


    public void login(String username, String password) {
        userNameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginButton.click();

    }
}
