package steps;

import org.openqa.selenium.WebDriver;
import pages.CartPage;
import pages.LoginPage;
import pages.ProductsPage;

public class CartSteps {

    private LoginPage loginPage;
    private ProductsPage productsPage;
    private CartPage cartPage;

    public CartSteps(LoginPage loginPage, ProductsPage productsPage, CartPage cartPage) {
        this.loginPage = loginPage;
        this.productsPage = productsPage;
        this.cartPage = cartPage;
    }


    public CartSteps AddProductToCart(){
        loginPage.openPage()
                .login("standard_user", "secret_sauce")
                .addProductToCart("Sauce Labs Bolt T-Shirt");
        cartPage.openPage();
        return this;
    }
}
