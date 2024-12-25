package com.lhind.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.lhind.selenium.utils.TestConfig;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private WebDriver driver;
    private WebDriverWait wait;

    // Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Helper methods
    private WebElement waitForElement(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    private void clickElement(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

    // Method to click login link
    public void clickLoginLink() {
        clickElement(TestConfig.loginLink);
    }
    // Method to input email
    public void enterEmail(String email) {
        waitForElement(TestConfig.emailField).sendKeys(email);
    }
    // Method to input password
    public void enterPassword(String password) {
        waitForElement(TestConfig.passwordField).sendKeys(password);
    }
    // Method to click login button
    public void clickLoginButton() {
        clickElement(TestConfig.loginButton);
    }
    // Method to verify if the Welcome message is displayed
    public boolean isWelcomeMessageDisplayed() {
        return waitForElement(TestConfig.welcomeMessage).isDisplayed();
    }
    // Method to check if Logout option is displayed
    public boolean isLogoutButtonDisplayed() {
        return waitForElement(TestConfig.logoutButton).isDisplayed();
    }
    // Method to click Logut button
    public void clickLogoutButton() {
        clickElement(TestConfig.logoutButton);
    }

    // Login method
    public void login(String email, String password) {
        clickLoginLink();
        enterEmail(email);
        enterPassword(password);
        clickLoginButton();
    }
}
