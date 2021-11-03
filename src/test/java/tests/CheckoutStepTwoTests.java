package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutStepTwoTests extends BaseTest {

    @Test
    public void clickFinishButtonTest() {
        loginPage.openPage()
                .login("standard_user", "secret_sauce")
                .addProductToCart("Sauce Labs Bolt T-Shirt")
                .openPage();
        cartPage.clickCheckOutButton()
                .fillField("Glieb", "Boiechko", "50-555")
                .clickContinueButton()
                .clickFinishButton();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/checkout-complete.html", "Error");
    }

    @Test
    public void clickCancelButtonTest() {
        loginPage.openPage()
                .login("standard_user", "secret_sauce")
                .addProductToCart("Sauce Labs Bolt T-Shirt")
                .openPage();
        cartPage.clickCheckOutButton()
                .fillField("Glieb", "Boiechko", "50-555")
                .clickContinueButton()
                .clickCancelButton();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html", "Error");
    }
}
