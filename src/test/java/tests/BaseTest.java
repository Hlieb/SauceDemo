package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import pages.*;
import steps.CartSteps;
import steps.CheckoutStep;
import steps.ProductSteps;

import java.util.concurrent.TimeUnit;

@Listeners(TestListener.class)
public class BaseTest {
    WebDriver driver;
    LoginPage loginPage;
    ProductsPage productsPage;
    CartPage cartPage;
    CheckoutPage checkoutPage;
    CheckoutStepTwoPage checkoutStepTwoPage;
    CheckoutCompletePage checkoutComplete;
    WebDriverWait wait;
    ProductSteps productSteps;
    CartSteps cartSteps;
    CheckoutStep checkoutStep;


    @BeforeMethod
    public void initTest() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        loginPage = new LoginPage(driver);
        productsPage = new ProductsPage(driver);
        cartPage = new CartPage(driver);
        checkoutPage = new CheckoutPage(driver);
        checkoutStepTwoPage = new CheckoutStepTwoPage(driver);
        checkoutComplete = new CheckoutCompletePage(driver);
        productSteps = new ProductSteps(driver);
        cartSteps = new CartSteps(driver);
        checkoutStep = new CheckoutStep(driver);

    }

    @AfterMethod
    public void closeDriver() {
        driver.quit();
    }
    public void waitForElementLocate(WebElement element, int timeout ) {
        wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

}