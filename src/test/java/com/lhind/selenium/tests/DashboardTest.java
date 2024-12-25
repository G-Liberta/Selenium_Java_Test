package com.lhind.selenium.tests;
import com.lhind.selenium.pages.Common;
import com.lhind.selenium.pages.DashboardPage;
import com.lhind.selenium.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DashboardTest extends Common{

    private WebDriver driver;
    private DashboardPage dashboardPage;
    private LoginPage loginPage;
    private static final String EMAIL = "liberta@gmail.com";
    private static final String PASSWORD = "User123";

    @BeforeMethod
    public void setUpTest() {
        setUp();
        dashboardPage = new DashboardPage(driver);
    }

    @Test
    public void testDashboard() {
        // Step 1: Log in
        try {
            loginPage.clickLoginLink();
            loginPage.enterEmail(EMAIL);
            loginPage.enterPassword(PASSWORD);
            loginPage.clickLoginButton();
        } catch (Exception e) {
            Assert.fail("Login failed: " + e.getMessage());
        }

        // Step 2: Hover over Computers Menu and click Notebooks
        dashboardPage.hoverAndClickNotebooks();

        // Step 3: Verify navigation to Notebooks Page
        Assert.assertTrue(dashboardPage.isNotebooksPageDisplayed(), "Notebooks page is not displayed");

        // Step 4: Choose 9 on Display dropdown
        dashboardPage.selectDisplayOption9();

        // Step 5: Verify that only 6 items are displayed
        Assert.assertTrue(dashboardPage.are6ItemsDisplayed(), "More than 6 items are displayed");

        // Step 6: Check 16GB filter
        dashboardPage.select16GBFilter();

        // Step 7: Verify that only 1 item is displayed
        Assert.assertTrue(dashboardPage.is1ItemDisplayedAfter16GBFilter(), "More than 1 item is displayed after 16GB filter");

        // Step 8: Uncheck the 16GB filter
        dashboardPage.uncheck16GBFilter();

        // Step 9: Verify that 6 items are displayed again
        Assert.assertTrue(dashboardPage.are6ItemsDisplayedAfterUnchecking16GB(), "More than 6 items are displayed after unchecking the 16GB filter");

        // Step 10-13: Add items to wishlist and cart, verify notifications
        dashboardPage.addToWishlist();
        dashboardPage.addToCart();

        // Step 14-15: Verify Wishlist and Shopping Cart counts
        Assert.assertTrue(dashboardPage.verifyWishlistCount(), "Wishlist count is incorrect");
        Assert.assertTrue(dashboardPage.verifyCartCount(), "Shopping cart count is incorrect");
    }

    @AfterMethod
    public void tearDownTest() {
        tearDown();
    }
}
