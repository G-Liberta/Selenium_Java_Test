package com.lhind.selenium.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.lhind.selenium.pages.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.apache.commons.io.FileUtils;

public class LoginTest {

    private WebDriver driver;
    private LoginPage loginPage;
    private WebDriverWait wait;

    private static final String BASE_URL = "https://demo.nopcommerce.com/";
    private static final String EMAIL = "liberta@gmail.com";
    private static final String PASSWORD = "User123";

    @BeforeMethod
    public void setUp() {
        // Use WebDriverManager to manage the ChromeDriver automatically
        WebDriverManager.chromedriver().setup();

        // Initialize ChromeOptions and set the browser options
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito"); // Optional: Open in incognito mode
        options.addArguments("--headless");  // Run in headless mode
        options.addArguments("--disable-gpu"); // Disable GPU (Recommended for CI/CD)
        options.addArguments("--window-size=1920,1080"); // Set screen size for headless

        // Initialize WebDriver (ChromeDriver in this case)
        driver = new ChromeDriver(options);

        // Maximize the browser window
        driver.manage().window().maximize();

        // Initialize WebDriverWait with a default timeout
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Initialize the LoginPage object
        loginPage = new LoginPage(driver);

        // Open the nopCommerce website
        loginPage.openPage(BASE_URL);
    }

    @Test
    public void testLogin() {
        try {
            // Click the Login link
            loginPage.clickLoginLink();
            System.out.println("Clicked the Login link.");

            // Inject a mock CAPTCHA token into the reCAPTCHA response field
            loginPage.injectMockCaptchaToken();

            // Enter email and password
            loginPage.enterEmail(EMAIL);
            System.out.println("Entered email: " + EMAIL);

            loginPage.enterPassword(PASSWORD);
            System.out.println("Entered password: " + PASSWORD);

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
        } catch (Exception e) {
            captureScreenshot("LoginTest_Failure");
            throw e; // Re-throw the exception after capturing the screenshot
        }
    }

    @AfterMethod
    public void tearDown() {
        // Wait a bit before closing to observe the result
        try {
            System.out.println("Waiting 5 seconds before closing...");
            Thread.sleep(5000); // 5-second delay before closing (Remove this if not needed)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Close the browser after the test is done
        if (driver != null) {
            driver.quit();
        }
    }

    // Method to capture screenshots
    private void captureScreenshot(String fileName) {
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshot, new File("screenshots/" + fileName + ".png"));
            System.out.println("Screenshot saved: screenshots/" + fileName + ".png");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
