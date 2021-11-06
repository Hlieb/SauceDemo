package tests;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LoginTest extends BaseTest {

    @DataProvider(name = "name")
    public Object[][] userData() {
        return new Object[][]{
                {"standard_user","secret_sauce"},
                {"standart_user", ""},
                {"", "standart_user"},
        };
    }

    @Test(dataProvider = "name",retryAnalyzer = RetryTest.class)
    public void loginWithCorrectDataTest(String username, String password) {
        loginPage.openPage()
                .login(username, password);
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html", "URL doesnt wait");
    }

    @Test
    public void loginWithInCorrectDataTest() {
        loginPage.openPage()
                .login("standard_user1", "locked_out_use1r");
        Assert.assertEquals(loginPage.getIncorrectLoginText(), "Epic sadface: Username and password do not match any user in this service", "Error");
    }

    @Test
    public void loginWithInCorrectUsernameTest() {
        loginPage.openPage()
                .login("standard_use1r1", "locked_out_user");
        Assert.assertEquals(loginPage.getIncorrectLoginText(), "Epic sadface: Username and password do not match any user in this service", "Error");
    }

    @Test
    public void loginWithoutUsernameTest() {
        loginPage.openPage()
                .login("", "locked_out_user");
        Assert.assertEquals(loginPage.getIncorrectUsername(), "Epic sadface: Username is required", "Error");
    }

    @Test
    public void loginWithoutPasswordTest() {
        loginPage.openPage()
                .login("standard_user", "");
        Assert.assertEquals(loginPage.getIncorrectPassword(), "Epic sadface: Password is required", "Error");
    }
}
