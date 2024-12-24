package com.lhind.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.time.Duration;


public class Common {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected LoginPage loginPage;

    private static final String BASE_URL = "https://demo.nopcommerce.com/";
    private static final String EMAIL = "liberta@gmail.com";
    private static final String PASSWORD = "User123";

    // Setup method
    public void setUp() {
        // Use WebDriverManager to manage the ChromeDriver automatically
        WebDriverManager.chromedriver().setup();

        // Initialize ChromeOptions
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("--window-size=1920,1080");

        // Initialize WebDriver
        driver = new ChromeDriver(options);

        // Maximize the browser window
        driver.manage().window().maximize();

        // Initialize WebDriverWait
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Initialize LoginPage
        loginPage = new LoginPage(driver);

        // Open the application
        driver.get(BASE_URL);
    }

    // Teardown method
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    // Login method
    public void login() {
        // Navigate to Login Page and perform login actions
        loginPage.clickLoginLink();
        loginPage.enterEmail(EMAIL);
        loginPage.enterPassword(PASSWORD);
        loginPage.clickLoginButton();
    }

    // Capture screenshot
    protected void captureScreenshot(String fileName) {
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshot, new File("screenshots/" + fileName + ".png"));
            System.out.println("Screenshot saved: screenshots/" + fileName + ".png");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

