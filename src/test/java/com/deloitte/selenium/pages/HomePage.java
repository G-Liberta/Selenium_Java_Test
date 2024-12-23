package com.deloitte.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    WebDriver driver;

    // Locator for the Register button using provided XPath
    By registerButton = By.xpath("//a[@class='ico-register' and contains(@href, '/register')]");

    // Constructor
    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    // Action: Click the Register button
    public void clickRegisterButton() {
        driver.findElement(registerButton).click();
    }
}
