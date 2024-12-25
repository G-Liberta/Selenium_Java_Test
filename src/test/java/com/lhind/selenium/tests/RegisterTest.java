package com.lhind.selenium.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.lhind.selenium.pages.RegisterPage;
import com.lhind.selenium.pages.Common;
import io.github.bonigarcia.wdm.WebDriverManager;
import static org.testng.Assert.assertTrue;
import java.time.Duration;

public class RegisterTest extends Common{

    private WebDriver driver;
    private RegisterPage registerPage;
    private WebDriverWait wait;
    private static final String BASE_URL = "https://demo.nopcommerce.com/";
    private static final String EMAIL = "liberta@gmail.com";
    private static final String PASSWORD = "User123";
    private static final String FIRST_NAME = "Liberta";
    private static final String LAST_NAME = "Gani";
    private static final String COMPANY_NAME = "Testcmp";

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
        registerPage = new RegisterPage(driver);

        // Open the nopCommerce website
        registerPage.openPage(BASE_URL);
    }

    @Test
    public void testRegister() {
        // Click the Register button
        registerPage.clickRegisterButton();
        System.out.println("Clicked the Register button.");

        // Wait for the Register page to load and verify the page title
        wait.until(ExpectedConditions.titleContains("Register"));
        String pageTitle = registerPage.getPageTitle();
        assertTrue(pageTitle.contains("Register"), "Expected page title to contain 'Register', but found: " + pageTitle);
        System.out.println("Verified page title: " + pageTitle);

        // Fill out the registration form
        registerPage.selectGenderFemale();
        System.out.println("Selected female gender.");

        registerPage.enterFirstName(FIRST_NAME);
        System.out.println("Entered first name: " + FIRST_NAME);

        registerPage.enterLastName(LAST_NAME);
        System.out.println("Entered last name: " + LAST_NAME);

        registerPage.selectDateOfBirth();
        System.out.println("Selected date of birth: 3rd October 1983.");

        registerPage.enterEmail(EMAIL);
        System.out.println("Entered email: " + EMAIL);

        registerPage.enterCompanyName(COMPANY_NAME);
        System.out.println("Entered company name: " + COMPANY_NAME);

        // Scroll down a bit to make sure the fields are visible
        registerPage.scrollDown();
        System.out.println("Scrolled down.");

        registerPage.enterPassword(PASSWORD);
        System.out.println("Entered password: " + PASSWORD);

        registerPage.enterConfirmPassword(PASSWORD);
        System.out.println("Entered confirm password: " + PASSWORD);

        // Click the register button to submit the form
        registerPage.clickRegisterSubmitButton();
        System.out.println("Clicked the final register button.");

        // Verify registration success message
        String successMessage = registerPage.getSuccessMessage();
        assertTrue(successMessage.contains("Your registration completed"), 
            "Expected success message to contain 'Your registration completed', but found: " + successMessage);
        System.out.println("Verified success message: " + successMessage);

        // Logout after successful registration
        registerPage.clickLogoutButton();
        System.out.println("Logged out successfully.");
    }

    @AfterMethod
    public void tearDownTest() {
        tearDown();
    }
}
