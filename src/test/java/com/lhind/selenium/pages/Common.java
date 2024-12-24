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
    private static final String BASE_URL = "https://demo.nopcommerce.com/";
    private static final Duration TIMEOUT = Duration.ofSeconds(10);

    // Setup method
    public void setUp() {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito", "--window-size=1920,1080");

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, TIMEOUT);
        driver.get(BASE_URL);
    }

    // Teardown method
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    // Capture screenshot
    protected void captureScreenshot(String fileName) {
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshot, new File("screenshots/" + fileName + ".png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
