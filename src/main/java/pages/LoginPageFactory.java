package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageFactory extends BasePage{

    public LoginPageFactory(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//*[@class='bot_column']")
    WebElement botLogo;

    public ProductsPage login(String username, String password) {
        waitForElementLocated(userNameInput, 10);
        userNameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginButton.click();
        return new ProductsPage(driver);
    }

    public void waitForPageOpened() {
        waitForElementLocated(botLogo, 10);
    }
}