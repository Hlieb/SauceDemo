package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutStepTwoTests extends BaseTest {

    @Test
    public void clickFinishButtonTest() {
        productSteps.loginAndAddProductToCart();
        checkoutStep.fillRequiredFields("Glieb", "Boiechko", "50-555");
        checkoutStepTwoPage.clickFinishButton();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/checkout-complete.html", "Error");
    }

    @Test
    public void clickCancelButtonTest() {
        productSteps.loginAndAddProductToCart();
        checkoutStep.fillRequiredFields("Glieb", "Boiechko", "50-555");
        checkoutStepTwoPage.clickCancelButton();
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html", "Error");
    }
}