package tests;

import lombok.extern.log4j.Log4j2;
import org.testng.Assert;
import org.testng.annotations.Test;


@Log4j2
public class CartTests extends BaseTest {


    @Test
    public void addProductToCartTest() {
        productSteps.loginAndAddProductToCart();
        cartPage.openPage();
        Assert.assertEquals(cartPage.getProductPrice("Sauce Labs Bolt T-Shirt"), "$15.99");
    }

    @Test
    public void addProductToCartWithPageFactoryTest() {
        productSteps.loginAndAddProductToCart();
        cartPage.openPage();
        Assert.assertEquals(cartPage.getProductPrice("Sauce Labs Bolt T-Shirt"), "$15.99");
    }
}