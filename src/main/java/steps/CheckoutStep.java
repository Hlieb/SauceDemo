package steps;

import org.openqa.selenium.WebDriver;
import pages.CartPage;
import pages.CheckoutPage;

public class CheckoutStep {
    private CheckoutPage checkoutPage;
    private CartPage cartPage;

    public CheckoutStep(WebDriver driver){
        checkoutPage = new CheckoutPage(driver);
        cartPage = new CartPage(driver);
    }

    public CheckoutStep fillRequiredFields(){
        cartPage.openPage()
                .clickCheckOutButton()
                .fillField("Glieb", "Boiechko", "50-555")
                .clickContinueButton();
        return this;
    }
}
