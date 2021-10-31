package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LoginTest extends BaseTest {

    @Test
    public void loginWithCorrectDataTest() {
        loginPage.openPage("https://www.saucedemo.com/");
        loginPage.login("standard_user", "secret_sauce");
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/inventory.html","URL doesnt wait");
    }

    @Test
    public void loginWithInCorrectDataTest() {
        loginPage.openPage("https://www.saucedemo.com/");
        loginPage.login("standard_user1", "locked_out_use1r");
        Assert.assertEquals(loginPage.getIncorrectLoginText(), "Epic sadface: Username and password do not match any user in this service", "Error");
    }

    @Test
    public void loginWithInCorrectUsernameTest() {
        loginPage.openPage("https://www.saucedemo.com/");
        loginPage.login("standard_use1r1", "locked_out_user");
        loginPage.getIncorrectLoginText();
        Assert.assertEquals(loginPage.getIncorrectLoginText(), "Epic sadface: Username and password do not match any user in this service", "Error");
    }


    @Test
    public void loginWithoutUsernameTest() {
        loginPage.openPage("https://www.saucedemo.com/");
        loginPage.login("", "locked_out_user");
        loginPage.getIncorrectUsername();
        Assert.assertEquals(loginPage.getIncorrectUsername(), "Epic sadface: Username is required", "Error");
    }

    @Test
    public void loginWithoutPasswordTest() {
        loginPage.openPage("https://www.saucedemo.com/");
        loginPage.login("standard_user", "");
        loginPage.getIncorrectPassword();
        Assert.assertEquals(loginPage.getIncorrectPassword(), "Epic sadface: Password is required", "Error");
    }
}
