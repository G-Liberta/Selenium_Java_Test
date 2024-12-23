package com.lhind.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TearDown {
    WebDriver driver;

    // Locators
    By logoutMenu = By.linkText("Log out");

    // Constructor
    public TearDown(WebDriver driver) {
        this.driver = driver;
    }

    // Actions
    public void clickLogoutMenu() {
        driver.findElement(logoutMenu).click();
    }
}
