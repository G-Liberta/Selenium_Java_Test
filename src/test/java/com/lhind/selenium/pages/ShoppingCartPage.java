package com.lhind.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.lhind.selenium.utils.TestConfig;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.math.BigDecimal;
import java.time.Duration;

public class ShoppingCartPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public ShoppingCartPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Hover over Shopping Cart menu
    public void hoverOverShoppingCartMenu() {
        Actions actions = new Actions(driver);
        WebElement shoppingCartElement = wait.until(ExpectedConditions.visibilityOfElementLocated(TestConfig.shoppingCartMenu));
        actions.moveToElement(shoppingCartElement).perform();
    }

    // Click 'Go To Cart' button
    public void clickGoToCartButton() {
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(TestConfig.goToCartButton));
        button.click();
    }

    // Verify Shopping Cart Page title
    public boolean isShoppingCartPageDisplayed() {
        return wait.until(ExpectedConditions.textToBePresentInElementLocated(TestConfig.shoppingCartTitle, "Shopping cart"));
    }

    // Verify buttons are displayed
    public boolean isUpdateCartButtonDisplayed() {
        return driver.findElement(TestConfig.updateCartButton).isDisplayed();
    }

    public boolean isContinueShoppingButtonDisplayed() {
        return driver.findElement(TestConfig.continueShoppingButton).isDisplayed();
    }

    public boolean isEstimateShippingButtonDisplayed() {
        return driver.findElement(TestConfig.estimateShippingButton).isDisplayed();
    }

    // Get price for a product
    private BigDecimal getPrice(By locator) {
        String priceText = driver.findElement(locator).getText().replace("$", "").trim();
        return new BigDecimal(priceText);
    }

    // Calculate total price of all products
    public BigDecimal calculateTotalPrice() {
        BigDecimal price1 = getPrice(TestConfig.priceForProduct1);
        BigDecimal price2 = getPrice(TestConfig.priceForProduct2);
        BigDecimal price3 = getPrice(TestConfig.priceForProduct3);
        return price1.add(price2).add(price3);
    }

    // Get the total price displayed at the bottom
    public BigDecimal getDisplayedTotalPrice() {
        String totalText = driver.findElement(TestConfig.totalPrice).getText().replace("$", "").trim();
        return new BigDecimal(totalText);
    }
}
