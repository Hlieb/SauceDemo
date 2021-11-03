package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutTest extends BaseTest {

    @Test
    public void checkoutWithCorrectData() {
        loginPage.openPage()
                .login("standard_user", "secret_sauce")
                .addProductToCart("Sauce Labs Bolt T-Shirt")
                .openPage();
        cartPage.clickCheckOutButton()
                .fillField("Glieb", "Boiechko", "50-555")
                .clickContinueButton();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/checkout-step-two.html", "Error");
    }

    @Test
    public void checkoutWithFilledFirstName() {
        loginPage.openPage()
                .login("standard_user", "secret_sauce")
                .addProductToCart("Sauce Labs Bolt T-Shirt")
                .openPage();
        cartPage.clickCheckOutButton()
                .checkOutOnlyWithFirstName("Glieb");
        Assert.assertEquals(checkoutPage.getCheckoutErrorText(), "Error: Last Name is required", "Error");
    }
}


