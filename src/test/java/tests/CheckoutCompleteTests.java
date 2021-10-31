package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutCompleteTests extends CheckoutStepTwoTests{

    @Test
    public void checkoutCompleteTest(){
        loginPage.openPage("https://www.saucedemo.com/");
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addProductToCart("Sauce Labs Bolt T-Shirt");
        productsPage.openPage("https://www.saucedemo.com/cart.html");
        cartPage.clickCheckOutButton();
        checkoutPage.fillField("Glieb","Boiechko","50-555");
        checkoutPage.clickContinueButton();
        checkoutStepTwoPage.clickFinishButton();
        checkoutComplete.getFinalCheckOutText();
        Assert.assertEquals(checkoutComplete.getFinalCheckOutText(),"CHECKOUT: COMPLETE!", "Error");
    }
}
