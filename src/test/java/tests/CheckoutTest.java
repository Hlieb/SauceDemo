package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutTest extends BaseTest {

    @Test
    public void checkoutWithCorrectData(){
        loginPage.openPage("https://www.saucedemo.com/");
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addProductToCart("Sauce Labs Bolt T-Shirt");
        productsPage.openPage("https://www.saucedemo.com/cart.html");
        cartPage.clickCheckOutButton();
        checkoutPage.fillField("Glieb","Boiechko","50-555");
        checkoutPage.clickContinueButton();
    }

    @Test
    public void checkoutWithFilledFirstName(){
        loginPage.openPage("https://www.saucedemo.com/");
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addProductToCart("Sauce Labs Bolt T-Shirt");
        productsPage.openPage("https://www.saucedemo.com/cart.html");
        cartPage.clickCheckOutButton();
        checkoutPage.checkOutOnlyWithFirstName("Glieb");
        Assert.assertEquals(checkoutPage.getCheckoutErrorText(),"Error: Last Name is required","Error");
    }
}


