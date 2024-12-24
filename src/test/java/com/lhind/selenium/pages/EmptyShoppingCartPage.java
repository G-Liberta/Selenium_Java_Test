package com.lhind.selenium.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class EmptyShoppingCartPage {

    private WebDriver driver;

    // Locators
    private By cartItemCount = By.xpath("//a[@href='/cart']//span[@class='cart-qty']");
    private By removeButton = By.xpath("(//button[@class='remove-btn'])[1]");
    private By emptyCartMessage = By.xpath("//div[@class='no-data']");
    private By cartItemsTable = By.xpath("//table[@class='cart']//tbody//tr");

    // Constructor
    public EmptyShoppingCartPage(WebDriver driver) {
        this.driver = driver;
    }

    // Methods
    public int getCartItemCount() {
        String cartQtyText = driver.findElement(cartItemCount).getText(); // E.g., "(3)"
        return Integer.parseInt(cartQtyText.replaceAll("[^0-9]", ""));
    }

    public int getNumberOfItemsInTable() {
        List<WebElement> rows = driver.findElements(cartItemsTable);
        return rows.size();
    }

    public void removeFirstItem() {
        driver.findElement(removeButton).click();
    }

    public boolean isCartEmpty() {
        return driver.findElements(emptyCartMessage).size() > 0;
    }
}

