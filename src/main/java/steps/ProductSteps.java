package steps;

import org.openqa.selenium.WebDriver;
import pages.LoginPage;
import pages.ProductsPage;

public class ProductSteps {

    private LoginPage loginPage;
    private ProductsPage productsPage;

    public ProductSteps(WebDriver driver) {
        this.loginPage = new LoginPage(driver);
        this.productsPage = new ProductsPage(driver);
    }

    public ProductSteps loginAndAddProductToCart(){
        loginPage.openPage()
                .login("standard_user", "secret_sauce")
                .addProductToCart("Sauce Labs Bolt T-Shirt");
        return this;
    }
}
