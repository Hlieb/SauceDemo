package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutStepTwoTests extends CheckoutTest {

    @Test
    public void clickFinishButtonTest() {
        loginPage.openPage("https://www.saucedemo.com/");
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addProductToCart("Sauce Labs Bolt T-Shirt");
        productsPage.openPage("https://www.saucedemo.com/cart.html");
        cartPage.clickCheckOutButton();
        checkoutPage.fillInUserData("Glieb","Boiechko","50-555");
        checkoutPage.clickContinueButton();
        checkoutStepTwoPage.clickFinishButton();
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/checkout-complete.html","Error");
    }

    @Test
    public void clickCancelButtonTest() {
        loginPage.openPage("https://www.saucedemo.com/");
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addProductToCart("Sauce Labs Bolt T-Shirt");
        productsPage.openPage("https://www.saucedemo.com/cart.html");
        cartPage.clickCheckOutButton();
        checkoutPage.fillInUserData("Glieb","Boiechko","50-555");
        checkoutPage.clickContinueButton();
        checkoutStepTwoPage.clickCancelButton();
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/inventory.html","Error");
    }
}
