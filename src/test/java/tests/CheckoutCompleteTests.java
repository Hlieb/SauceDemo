package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutCompleteTests extends BaseTest {

    @Test
    public void checkoutCompleteTest() {
        productSteps.loginAndAddProductToCart();
        checkoutStep.fillRequiredFields("Glieb", "Boiechko", "50-555");
        checkoutStepTwoPage.clickFinishButton();
        Assert.assertEquals(checkoutComplete.getFinalCheckOutText(), "CHECKOUT: COMPLETE!", "Error");
    }
}
