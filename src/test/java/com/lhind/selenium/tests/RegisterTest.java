package com.lhind.selenium.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.lhind.selenium.pages.RegisterPage;
import static org.testng.Assert.assertTrue;

import java.time.Duration;

public class RegisterTest {
    private WebDriver driver;
    private RegisterPage registerPage;

    @BeforeMethod
    public void setUp() {
        // Set the system property for ChromeDriver
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\CRS\\Downloads\\chromedriver-win64\\chromedriver.exe"); // Path to ChromeDriver

        // Initialize ChromeOptions to specify Chrome for testing binary
        ChromeOptions options = new ChromeOptions();

        // Set the path to the Chrome for testing binary (downloaded version)
        options.setBinary("C:\\Users\\CRS\\Downloads\\chrome-win64\\chrome.exe"); // Path to Chrome for testing binary

        // Initialize ChromeDriver with the specified options
        driver = new ChromeDriver(options);

        // Maximize the browser window
        driver.manage().window().maximize();

        // Initialize the RegisterPage object
        registerPage = new RegisterPage(driver);

        // Open the nopCommerce website
        registerPage.openPage();
    }

    @Test
    public void testRegister() {
        // Click the Register button
        registerPage.clickRegisterButton();
        System.out.println("Clicked the Register button.");

        // Wait for the Register page to load and verify the page title
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.titleContains("Register"));
        String pageTitle = registerPage.getPageTitle();
        assertTrue(pageTitle.contains("Register"), "Expected page title to contain 'Register', but found: " + pageTitle);
        System.out.println("Verified page title: " + pageTitle);

        // Fill out the registration form
        registerPage.selectGenderFemale();
        System.out.println("Selected female gender.");

        registerPage.enterFirstName("Liberta");
        System.out.println("Entered first name: Liberta.");

        registerPage.enterLastName("Gani");
        System.out.println("Entered last name: Gani.");

        registerPage.selectDateOfBirth();
        System.out.println("Selected date of birth: 3rd October 1983.");

        registerPage.enterEmail("liberta@gmail.com");
        System.out.println("Entered email: liberta@gmail.com.");

        registerPage.enterCompanyName("Testcmp");
        System.out.println("Entered company name: Testcmp.");

        // Scroll down a bit to make sure the fields are visible
        registerPage.scrollDown();
        System.out.println("Scrolled down.");

        registerPage.enterPassword("User123");
        System.out.println("Entered password: User123.");

        registerPage.enterConfirmPassword("User123");
        System.out.println("Entered confirm password: User123.");

        // Click the register button to submit the form
        registerPage.clickRegisterSubmitButton();
        System.out.println("Clicked the final register button.");

        // Verify registration success message
        String successMessage = registerPage.getSuccessMessage();
        assertTrue(successMessage.contains("Your registration completed"), "Expected success message to contain 'Your registration completed', but found: " + successMessage);
        System.out.println("Verified success message: " + successMessage);

        // Logout after successful registration
        registerPage.clickLogoutButton();
        System.out.println("Logged out successfully.");

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
