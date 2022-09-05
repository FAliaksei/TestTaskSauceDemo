package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage extends BasePage {

    public static final By PAGE_TITLE = By.cssSelector(".title");
    public static final By SHOPPING_CART_BUTTON = By.cssSelector(".shopping_cart_link");
    String productAddToCart = "//div[text()='%s']/ancestor::div[@class='inventory_item']//button[text()='Add to cart']";

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public void addProductToCart(String product) {
        driver.findElement(By.xpath(String.format(productAddToCart, product))).click();
    }

    public String getTitle() {
        return driver.findElement(PAGE_TITLE).getText();
    }

    public void openShoppingCart() {
        driver.findElement(SHOPPING_CART_BUTTON).click();
    }
}
