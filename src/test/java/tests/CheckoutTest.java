package tests;

import org.testng.annotations.Test;

import java.util.Arrays;

import static org.testng.Assert.assertEquals;

public class CheckoutTest extends BaseTest {

    @Test
    public void checkoutFullBuy() {
        loginPage.openLoginPage();
        loginPage.login(user, password);
        assertEquals(productsPage.getTitle(), "PRODUCTS", "Login failed");
        productsPage.addProductToCart("Sauce Labs Backpack");
        productsPage.addProductToCart("Sauce Labs Bike Light");
        productsPage.addProductToCart("Sauce Labs Bolt T-Shirt");
        productsPage.addProductToCart("Sauce Labs Fleece Jacket");
        productsPage.openShoppingCart();
        assertEquals(cartPage.getTitle(), "YOUR CART", "Cart page didn't open");
        assertEquals(cartPage.getProductsCount(), 4, "Product count didn't match");
        assertEquals(Arrays.toString(cartPage.getProductsNames()), "[Sauce Labs Backpack, Sauce Labs Bike Light," +
                " Sauce Labs Bolt T-Shirt, Sauce Labs Fleece Jacket]", "Products names didn't match");
        cartPage.removeFromCart("Sauce Labs Backpack");
        assertEquals(cartPage.getProductsCount(), 3, "Product count didn't match");
        assertEquals(Arrays.toString(cartPage.getProductsNames()), "[Sauce Labs Bike Light," +
                " Sauce Labs Bolt T-Shirt, Sauce Labs Fleece Jacket]", "Products names didn't match");
        cartPage.goToCheckout();
        checkoutPage.fillInCheckoutInfo("Aliaksei", "Fursa", "220117");
        assertEquals(checkoutPage.getTotalPrice(), "Total: $82.05", "Price didn't match");
        checkoutPage.finishCheckout();
        assertEquals(checkoutPage.getConfirmationMessage(), "THANK YOU FOR YOUR ORDER", "Order wasn't confirmed");
    }
}
