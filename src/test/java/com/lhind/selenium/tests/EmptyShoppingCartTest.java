package com.lhind.selenium.tests;

import com.lhind.selenium.base.BaseTest;
import com.lhind.selenium.pages.EmptyShoppingCartPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EmptyShoppingCartTest extends BaseTest {

    @Test
    public void testEmptyShoppingCart() {
        EmptyShoppingCartPage shoppingCartPage = new EmptyShoppingCartPage(driver);

        // Step 1: Verify the initial number of items in the cart
        int initialCartCount = shoppingCartPage.getCartItemCount();
        int initialTableCount = shoppingCartPage.getNumberOfItemsInTable();

        Assert.assertEquals(initialCartCount, initialTableCount, "Cart count and table count do not match.");

        // Step 2 & 3: Remove items one by one and verify the count decreases
        while (shoppingCartPage.getNumberOfItemsInTable() > 0) {
            int itemsBeforeRemoval = shoppingCartPage.getNumberOfItemsInTable();
            shoppingCartPage.removeFirstItem();

            // Wait for table to update
            int itemsAfterRemoval = shoppingCartPage.getNumberOfItemsInTable();
            Assert.assertEquals(itemsAfterRemoval, itemsBeforeRemoval - 1, "Item count did not decrease after removal.");
        }

        // Step 4: Verify the cart is empty
        Assert.assertTrue(shoppingCartPage.isCartEmpty(), "Shopping cart is not empty.");

        // Step 5: Close the browser
        driver.quit();
    }
}
