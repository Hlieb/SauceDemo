package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutTest extends BaseTest {

    @Test
    public void checkoutWithCorrectData() {
        productSteps.loginAndAddProductToCart();
        checkoutStep.fillRequiredFields("Glieb","Boiechko","50-555");
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/checkout-step-two.html", "Error");
    }

    @Test
    public void checkoutWithFilledFirstName() {
        productSteps.loginAndAddProductToCart();
        cartPage.openPage()
                .clickCheckOutButton()
                .checkOutOnlyWithFirstName("Glieb");
        Assert.assertEquals(checkoutPage.getCheckoutErrorText(), "Error: Last Name is required", "Error");
    }
}