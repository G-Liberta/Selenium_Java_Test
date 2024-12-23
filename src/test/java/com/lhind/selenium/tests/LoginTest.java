package com.lhind.selenium.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.lhind.selenium.pages.LoginPage;
import static org.testng.Assert.assertTrue;

public class LoginTest {
    private WebDriver driver;
    private LoginPage loginPage;

    @BeforeMethod
    public void setUp() {
        // Set the system property for ChromeDriver
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\CRS\\Downloads\\chromedriver-win64\\chromedriver.exe"); // Path to ChromeDriver

        // Initialize ChromeOptions to specify Chrome for testing binary
        ChromeOptions options = new ChromeOptions();

        // Set the path to the Chrome for testing binary (downloaded version)
        options.setBinary("C:\\Users\\CRS\\Downloads\\chrome-win64\\chrome.exe"); // Path to Chrome for testing binary

         // Add the argument for incognito mode
         options.addArguments("--incognito");
        
        // Initialize ChromeDriver with the specified options
        driver = new ChromeDriver(options);

        // Maximize the browser window
        driver.manage().window().maximize();

        // Initialize the LoginPage object
        loginPage = new LoginPage(driver);

        // Open the nopCommerce website
        loginPage.openPage();
    }

    @Test
    public void testLogin() {
        // Click the Login link
        loginPage.clickLoginLink();
        System.out.println("Clicked the Login link.");

        // Enter email and password
        loginPage.enterEmail("liberta@gmail.com"); // Use credentials from Test 1
        System.out.println("Entered email: liberta@gmail.com.");

        loginPage.enterPassword("User123"); // Use password from Test 1
        System.out.println("Entered password: User123.");

        // Click the Log in button
        loginPage.clickLoginButton();
        System.out.println("Clicked the Log in button.");

        // Verify the Welcome message is displayed
        assertTrue(loginPage.isWelcomeMessageDisplayed(), "Welcome message is not displayed.");
        System.out.println("Verified Welcome message is displayed.");

        // Verify the Logout button is displayed
        assertTrue(loginPage.isLogoutButtonDisplayed(), "Logout button is not displayed.");
        System.out.println("Verified Logout button is displayed.");

        // Click the Logout button
        loginPage.clickLogoutButton();
        System.out.println("Clicked the Logout button.");
    }

    @AfterMethod
    public void tearDown() {
        // Wait a bit before closing to observe the result
        try {
            System.out.println("Waiting 5 seconds before closing...");
            Thread.sleep(5000);  // 5-second delay before closing
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Close the browser after the test is done
        if (driver != null) {
            driver.quit();
        }
    }
}
