package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutCompleteTests extends BaseTest {

    @Test
    public void checkoutCompleteTest() {
        productSteps.loginAndAddProductToCart();
        checkoutStep.fillRequiredFields();
        checkoutStepTwoPage.clickFinishButton();
        Assert.assertEquals(checkoutComplete.getFinalCheckOutText(), "CHECKOUT: COMPLETE!", "Error");
    }
}
