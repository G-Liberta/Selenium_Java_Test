package com.lhind.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;


public class LoginPage {
    private WebDriver driver;

    // Locators
    private By loginLink = By.xpath("//a[@class='ico-login' and text()='Log in']");
    private By emailField = By.xpath("//input[@id='Email']");
    private By passwordField = By.xpath("//input[@id='Password']");
    private By loginButton = By.xpath("//button[@class='button-1 login-button' and text()='Log in']");
    private By welcomeMessage = By.xpath("//div[@class='topic-block-title']/h2");
    private By logoutButton = By.xpath("//a[@class='ico-logout' and text()='Log out']");

    // Constructor
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // Private method for explicit wait to check if element is visible
    private void waitUntilElementIsVisible(By locator, Duration timeout) {
        new WebDriverWait(driver, timeout)
                .until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    // Private method for explicit wait to check if element is clickable
    private void waitUntilElementIsClickable(By locator, Duration timeout) {
        new WebDriverWait(driver, timeout)
                .until(ExpectedConditions.elementToBeClickable(locator));
    }

    // Method to open the page
    public void openPage(String url) {
        driver.get(url);
    }

    // Method to click the Login link
    public void clickLoginLink() {
        waitUntilElementIsClickable(loginLink, Duration.ofSeconds(10));
        driver.findElement(loginLink).click();
    }

    // Method to enter email
    public void enterEmail(String email) {
        waitUntilElementIsVisible(emailField, Duration.ofSeconds(10));
        driver.findElement(emailField).sendKeys(email);
    }

    // Method to enter password
    public void enterPassword(String password) {
        waitUntilElementIsVisible(passwordField, Duration.ofSeconds(10));
        driver.findElement(passwordField).sendKeys(password);
    }

    // Method to click the Login button
    public void clickLoginButton() {
        waitUntilElementIsClickable(loginButton, Duration.ofSeconds(10));
        driver.findElement(loginButton).click();
    }

    // Method to check if welcome message is displayed
    public boolean isWelcomeMessageDisplayed() {
        waitUntilElementIsVisible(welcomeMessage, Duration.ofSeconds(10));
        return driver.findElement(welcomeMessage).isDisplayed();
    }

    // Method to check if Logout button is displayed
    public boolean isLogoutButtonDisplayed() {
        waitUntilElementIsVisible(logoutButton, Duration.ofSeconds(10));
        return driver.findElement(logoutButton).isDisplayed();
    }

    // Method to click the Logout button
    public void clickLogoutButton() {
        waitUntilElementIsClickable(logoutButton, Duration.ofSeconds(10));
        driver.findElement(logoutButton).click();
    }

}
