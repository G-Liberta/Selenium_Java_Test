package com.lhind.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LoginPage {
    private WebDriver driver;
    private WebDriverWait wait;

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
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    // Open Page
    public void openPage() {
        driver.get("https://demo.nopcommerce.com/");
    }

    public void clickLoginLink() {
        wait.until(ExpectedConditions.elementToBeClickable(loginLink)).click();
    }

    public void enterEmail(String email) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(emailField)).sendKeys(email);
    }

    public void enterPassword(String password) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField)).sendKeys(password);
    }

    public void clickLoginButton() {
        wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
    }

    public boolean isWelcomeMessageDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(welcomeMessage)).isDisplayed();
    }

    public boolean isLogoutButtonDisplayed() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(logoutButton)).isDisplayed();
    }

    public void clickLogoutButton() {
        wait.until(ExpectedConditions.elementToBeClickable(logoutButton)).click();
    }
}