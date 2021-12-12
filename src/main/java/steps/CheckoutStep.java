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

    public CheckoutStep fillRequiredFields(String firstname, String surname, String postcode){
        cartPage.openPage()
                .clickCheckOutButton()
                .fillField(firstname, surname, postcode)
                .clickContinueButton();
        return this;
    }
}
