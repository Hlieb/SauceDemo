package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutTest extends CartTests {

    @Test
    public void checkoutWithCorrectData(){
        loginPage.openPage("https://www.saucedemo.com/");
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addProductToCart("Sauce Labs Bolt T-Shirt");
        productsPage.openPage("https://www.saucedemo.com/cart.html");
        cartPage.checkOut();
        checkoutPage.checkOut("Glieb","Boiechko","50-555");
        Assert.assertEquals(checkoutPage.finishBuying(),"CHECKOUT: COMPLETE!","Error");
    }

    @Test
    public void checkoutWithFilledFirstName(){
        loginPage.openPage("https://www.saucedemo.com/");
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addProductToCart("Sauce Labs Bolt T-Shirt");
        productsPage.openPage("https://www.saucedemo.com/cart.html");
        cartPage.checkOut();
        checkoutPage.checkOutOnlyWithFirstName("Glieb");
        Assert.assertEquals(checkoutPage.ErrorCheckoutInfo(),"Error: Last Name is required","Error");
    }



}


