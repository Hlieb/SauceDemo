package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTests extends BaseTest {

    @Test
    public void addProductToCartTest() {
        loginPage.waitForPageOpened()
        .login("standard_user", "secret_sauce");
                //.addProductToCart("Sauce Labs Bolt T-Shirt");
        productsPage.openPage();
        Assert.assertEquals(cartPage.getProductPrice("Sauce Labs Bolt T-Shirt"), "$15.99");
    }

    @Test
    public void getProductQuantityTest(){
        loginPageFactory.openPage("https://www.saucedemo.com/");
        loginPageFactory.login("standard_user", "secret_sauce");
        productsPage.addProductToCart("Sauce Labs Bolt T-Shirt");
        productsPage.openPage("https://www.saucedemo.com/cart.html");
        cartPage.getProductQuantity("Sauce Labs Bolt T-Shirt");
        Assert.assertEquals(cartPage.getProductQuantity("Sauce Labs Bolt T-Shirt"),"1","Error");
    }
}
