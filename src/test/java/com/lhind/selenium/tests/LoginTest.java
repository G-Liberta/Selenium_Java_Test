package com.lhind.selenium.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import com.lhind.selenium.pages.LoginPage;
import static org.testng.Assert.assertTrue;

public class LoginTest {
    private WebDriver driver;
    private LoginPage loginPage;

    @Parameters({"browser"})
    @BeforeMethod
    public void setUp(String browser) {
        // Initialize WebDriver based on the browser parameter
        driver = getWebDriver(browser);

        // Maximize the browser window
        driver.manage().window().maximize();

        // Initialize the LoginPage object
        loginPage = new LoginPage(driver);

        // Open the nopCommerce website
        loginPage.openPage("https://demo.nopcommerce.com/"); // It's better to pass the URL as a parameter.
    }

    @Test
    public void testLogin() {
        // Click the Login link
        loginPage.clickLoginLink();

        // Enter email and password (use valid test credentials)
        loginPage.enterEmail("liberta@gmail.com");
        loginPage.enterPassword("User123");

        // Click the Log in button
        loginPage.clickLoginButton();

        // Verify the Welcome message is displayed
        assertTrue(loginPage.isWelcomeMessageDisplayed(), "Welcome message is not displayed.");

        // Verify the Logout button is displayed
        assertTrue(loginPage.isLogoutButtonDisplayed(), "Logout button is not displayed.");

        // Click the Logout button
        loginPage.clickLogoutButton();
    }

    @AfterMethod
    public void tearDown() {
        // Close the browser after the test is done
        if (driver != null) {
            driver.quit();
        }
    }

    private WebDriver getWebDriver(String browser) {
        // Return the appropriate WebDriver based on the browser
        if (browser.equalsIgnoreCase("chrome")) {
            // Set the system property for ChromeDriver
            System.setProperty("webdriver.chrome.driver", "C:\\Users\\CRS\\Downloads\\chromedriver-win64\\chromedriver.exe");

            // Initialize ChromeOptions to specify Chrome for testing binary
            ChromeOptions options = new ChromeOptions();
            options.setBinary("C:\\Users\\CRS\\Downloads\\chrome-win64\\chrome.exe");
            options.addArguments("--incognito");

            return new ChromeDriver(options);
        } else if (browser.equalsIgnoreCase("edge")) {
            // Set the system property for EdgeDriver
            System.setProperty("webdriver.edge.driver", "C:\\Users\\CRS\\Downloads\\msedgedriver.exe"); 

            return new EdgeDriver();
        } else {
            throw new IllegalArgumentException("Browser not supported: " + browser);
        }
    }
}
