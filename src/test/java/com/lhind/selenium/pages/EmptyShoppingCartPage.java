package com.lhind.selenium.pages;

import org.openqa.selenium.WebDriver;
import com.lhind.selenium.utils.TestConfig;
import org.openqa.selenium.WebElement;
import java.util.List;

public class EmptyShoppingCartPage {

    private WebDriver driver;


    // Constructor
    public EmptyShoppingCartPage(WebDriver driver) {
        this.driver = driver;
    }

    // Methods
    public int getCartItemCount() {
        String cartQtyText = driver.findElement(TestConfig.cartItemCount).getText(); // E.g., "(3)"
        return Integer.parseInt(cartQtyText.replaceAll("[^0-9]", ""));
    }

    public int getNumberOfItemsInTable() {
        List<WebElement> rows = driver.findElements(TestConfig.cartItemsTable);
        return rows.size();
    }

    public void removeFirstItem() {
        driver.findElement(TestConfig.removeButton).click();
    }

    public boolean isCartEmpty() {
        return driver.findElements(TestConfig.emptyCartMessage).size() > 0;
    }
}

