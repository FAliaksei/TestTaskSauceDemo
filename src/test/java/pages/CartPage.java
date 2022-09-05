package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePage {

    public static final By PAGE_TITLE = By.cssSelector(".title");
    public static final By CHECKOUT_BUTTON = By.id("checkout");
    public static final By PRODUCT_IN_CART = By.cssSelector(".cart_item");
    public static final By PRODUCT_NAME = By.cssSelector(".inventory_item_name");
    String productRemoveFromCart = "//div[text()='%s']/ancestor::div[@class='cart_item']//button[text()='Remove']";

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public String getTitle() {
        return driver.findElement(PAGE_TITLE).getText();
    }

    public void goToCheckout() {
        driver.findElement(CHECKOUT_BUTTON).click();
    }

    public void removeFromCart(String product) {
        driver.findElement(By.xpath(String.format(productRemoveFromCart, product))).click();
    }

    public int getProductsCount() {
        return driver.findElements(PRODUCT_IN_CART).size();
    }

    public String[] getProductsNames() {
        int i = driver.findElements(PRODUCT_IN_CART).size();
        String[] productsNames = new String[i];
        for (int n = 0; n < i; n++) {
            productsNames[n] = driver.findElements(PRODUCT_NAME).get(n).getText();
        }
        return productsNames;
    }
}
