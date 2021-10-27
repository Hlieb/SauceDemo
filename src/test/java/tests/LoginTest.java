package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test
    public void loginWithCorrectDataTest() {
        loginPage.openPage("https://www.saucedemo.com/");
        loginPage.login("standard_user", "locked_out_user");
    }

    @Test
    public void loginWithInCorrectDataTest() {
        loginPage.openPage("https://www.saucedemo.com/");
        loginPage.login("standard_user1", "locked_out_use1r");
        Assert.assertEquals(loginPage.incorrectLoginData(), "Epic sadface: Username and password do not match any user in this service", "Error");
    }

    @Test
    public void loginWithInCorrectUsernameTest() {
        loginPage.openPage("https://www.saucedemo.com/");
        loginPage.login("standard_use1r1", "locked_out_user");
        loginPage.incorrectLoginData();
        Assert.assertEquals(loginPage.incorrectLoginData(), "Epic sadface: Username and password do not match any user in this service", "Error");
    }


    @Test
    public void loginWithoutUsernameTest() {
        loginPage.openPage("https://www.saucedemo.com/");
        loginPage.login("", "locked_out_user");
        loginPage.incorrectUsername();
        Assert.assertEquals(loginPage.incorrectUsername(), "Epic sadface: Username is required", "Error");
    }

    @Test
    public void loginWithoutPasswordTest() {
        loginPage.openPage("https://www.saucedemo.com/");
        loginPage.login("standard_user", "");
        loginPage.incorrectPassword();
        Assert.assertEquals(loginPage.incorrectPassword(), "Epic sadface: Password is required", "Error");
    }
}
