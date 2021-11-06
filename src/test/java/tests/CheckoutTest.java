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
        checkoutPage.fillInUserData("Glieb","Boiechko","50-555");
        checkoutPage.clickContinueButton();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html", "Error");
    }

    @Test
    public void checkoutWithFilledFirstName(){
        loginPage.openPage("https://www.saucedemo.com/");
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addProductToCart("Sauce Labs Bolt T-Shirt");
        productsPage.openPage("https://www.saucedemo.com/cart.html");
        cartPage.clickCheckOutButton();
        checkoutPage.fillInFirstName("Glieb");
        checkoutPage.clickContinueButton();
        Assert.assertEquals(checkoutPage.getCheckoutErrorText(),"Error: Last Name is required","Error");
    }
}


