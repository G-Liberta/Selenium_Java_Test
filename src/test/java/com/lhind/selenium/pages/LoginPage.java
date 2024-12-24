package com.lhind.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    private WebDriver driver;
    private WebDriverWait wait;

    // Locators
    private final By loginLink = By.xpath("//a[@class='ico-login' and text()='Log in']");
    private final By emailField = By.id("Email");
    private final By passwordField = By.id("Password");
    private final By loginButton = By.xpath("//button[@class='button-1 login-button' and text()='Log in']");
    private final By welcomeMessage = By.xpath("//div[@class='topic-block-title']/h2");
    private final By logoutButton = By.xpath("//a[@class='ico-logout' and text()='Log out']");

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

    // Actions
    public void clickLoginLink() {
        clickElement(loginLink);
    }

    public void enterEmail(String email) {
        waitForElement(emailField).sendKeys(email);
    }

    public void enterPassword(String password) {
        waitForElement(passwordField).sendKeys(password);
    }

    public void clickLoginButton() {
        clickElement(loginButton);
    }

    public boolean isWelcomeMessageDisplayed() {
        return waitForElement(welcomeMessage).isDisplayed();
    }

    public boolean isLogoutButtonDisplayed() {
        return waitForElement(logoutButton).isDisplayed();
    }

    public void clickLogoutButton() {
        clickElement(logoutButton);
    }

    // Login method
    public void login(String email, String password) {
        enterEmail(email);
        enterPassword(password);
        clickLoginButton();
    }
}
