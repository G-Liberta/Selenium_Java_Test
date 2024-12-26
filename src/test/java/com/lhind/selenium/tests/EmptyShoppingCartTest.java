package com.lhind.selenium.tests;

import com.lhind.selenium.pages.Common;
import com.lhind.selenium.pages.DashboardPage;
import com.lhind.selenium.pages.EmptyShoppingCartPage;
import com.lhind.selenium.pages.LoginPage;


import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class EmptyShoppingCartTest extends Common {

    private WebDriver driver;
    private EmptyShoppingCartPage emptyShoppingCartPage;
    private LoginPage loginPage;
    private DashboardPage dashboardPage;
    private static final String EMAIL = "liberta@gmail.com";
    private static final String PASSWORD = "User123";

    
        @BeforeMethod
        public void setUpTest() {
            setUp();
            emptyShoppingCartPage = new EmptyShoppingCartPage(driver);
    }

    @Test
    public void testEmptyShoppingCart() {

        // Log in precondition
        try {
            loginPage.clickLoginLink();
            loginPage.enterEmail(EMAIL);
            loginPage.enterPassword(PASSWORD);
            loginPage.clickLoginButton();
        } catch (Exception e) {
            Assert.fail("Login failed: " + e.getMessage());
        }

        // Precondition: Complete Dashboard steps
        try {
            dashboardPage.hoverAndClickNotebooks();
            dashboardPage.addToCart();
            }
        catch (Exception e) {
            Assert.fail("Dashboard preconditions failed: " + e.getMessage());
        }
        
        EmptyShoppingCartPage shoppingCartPage = new EmptyShoppingCartPage(driver);

        // Step 1: Verify the initial number of items in the cart
        int initialCartCount = shoppingCartPage.getCartItemCount();
        int initialTableCount = shoppingCartPage.getNumberOfItemsInTable();

        Assert.assertEquals(initialCartCount, initialTableCount, "Cart count and table count do not match.");

        // Step 2 & 3: Remove items one by one and verify the count decreases
        while (shoppingCartPage.getNumberOfItemsInTable() > 0) {
            int itemsBeforeRemoval = shoppingCartPage.getNumberOfItemsInTable();
            shoppingCartPage.removeFirstItem();

            // Wait for table to update
            int itemsAfterRemoval = shoppingCartPage.getNumberOfItemsInTable();
            Assert.assertEquals(itemsAfterRemoval, itemsBeforeRemoval - 1, "Item count did not decrease after removal.");
        }

        // Step 4: Verify the cart is empty
        Assert.assertTrue(shoppingCartPage.isCartEmpty(), "Shopping cart is not empty.");

        // Step 5: Close the browser
        driver.quit();
    }
}
