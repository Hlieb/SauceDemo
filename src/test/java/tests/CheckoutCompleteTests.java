package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CheckoutCompleteTests extends BaseTest {

    @Test
    public void checkoutCompleteTest() {
        productSteps.loginAndAddProductToCart();
        cartPage.openPage()
                .clickCheckOutButton()
                .fillField("Glieb", "Boiechko", "50-555")
                .clickContinueButton()
                .clickFinishButton();
        Assert.assertEquals(checkoutComplete.getFinalCheckOutText(), "CHECKOUT: COMPLETE!", "Error");
    }
}
