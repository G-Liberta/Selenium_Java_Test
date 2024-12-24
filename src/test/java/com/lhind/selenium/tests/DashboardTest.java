package com.lhind.selenium.tests;
import com.lhind.selenium.pages.DashboardPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DashboardTest {

    private WebDriver driver;
    private DashboardPage dashboardPage;
    private WebDriverWait wait;
    private static final String BASE_URL = "https://demo.nopcommerce.com/";

    @BeforeMethod
    public void setUp() {
        // Use WebDriverManager to manage the ChromeDriver automatically
        WebDriverManager.chromedriver().setup();

        // Initialize ChromeOptions and set the browser options
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");  // Optional: Open in incognito mode

        // Initialize WebDriver (ChromeDriver in this case)
        driver = new ChromeDriver(options);

        // Maximize the browser window
        driver.manage().window().maximize();

        // Initialize WebDriverWait with a default timeout
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Initialize the RegisterPage object
        dashboardPage = new DashboardPage(driver);

        // Open the nopCommerce website
        dashboardPage.openPage(BASE_URL);
    }

    @Test
    public void testDashboard() {
        // Step 1: Log is handled in a separate test

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

    @AfterClass
    public void tearDown() {
        driver.quit();  // Close the browser after the test
    }
}
