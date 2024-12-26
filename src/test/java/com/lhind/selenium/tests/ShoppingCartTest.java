package com.lhind.selenium.tests;

import com.lhind.selenium.pages.Common;
import com.lhind.selenium.pages.LoginPage;
import com.lhind.selenium.pages.ShoppingCartPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.math.BigDecimal;

public class ShoppingCartTest extends Common {

    private WebDriver driver;
    private ShoppingCartPage shoppingCartPage;
    private LoginPage loginPage;
    private static final String EMAIL = "liberta@gmail.com";
    private static final String PASSWORD = "User123";

    @BeforeMethod
    public void setUpTest() {
        setUp();
        shoppingCartPage = new ShoppingCartPage(driver);
    }

    @Test(dependsOnMethods = "com.lhind.selenium.tests.DashboardTest.testDashboard")
    public void testShoppingCart() {
        // Log in precondition
        try {
            loginPage.clickLoginLink();
            loginPage.enterEmail(EMAIL);
            loginPage.enterPassword(PASSWORD);
            loginPage.clickLoginButton();
        } catch (Exception e) {
            Assert.fail("Login failed: " + e.getMessage());
        }

        // Step 1: Hover over Shopping Cart menu
        shoppingCartPage.hoverOverShoppingCartMenu();

        // Step 2: Verify 'Go To Cart' button is displayed
        Assert.assertTrue(shoppingCartPage.isUpdateCartButtonDisplayed(), "'Go To Cart' button is not displayed!");

        // Step 3: Click 'Go To Cart' button
        shoppingCartPage.clickGoToCartButton();

        // Step 4: Verify Shopping Cart Page
        Assert.assertTrue(shoppingCartPage.isShoppingCartPageDisplayed(), "Failed to navigate to Shopping Cart Page!");

        // Step 5: Verify buttons
        Assert.assertTrue(shoppingCartPage.isUpdateCartButtonDisplayed(), "'Update Shopping Cart' button is not displayed!");
        Assert.assertTrue(shoppingCartPage.isContinueShoppingButtonDisplayed(), "'Continue Shopping' button is not displayed!");
        Assert.assertTrue(shoppingCartPage.isEstimateShippingButtonDisplayed(), "'Estimate Shipping' button is not displayed!");

        // Step 6: Verify total price calculation
        BigDecimal calculatedTotal = shoppingCartPage.calculateTotalPrice();
        BigDecimal displayedTotal = shoppingCartPage.getDisplayedTotalPrice();
        Assert.assertEquals(calculatedTotal, displayedTotal, "The calculated total price does not match the displayed total!");

    }
    // Step 7: Close the browser (handled by BaseTest teardown)
    @AfterMethod
    public void tearDownTest() {
        tearDown();
    }
}
