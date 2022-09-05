package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage extends BasePage {

    public static final By FIRST_NAME_INPUT = By.id("first-name");
    public static final By LAST_NAME_INPUT = By.id("last-name");
    public static final By POSTAL_CODE_INPUT = By.id("postal-code");
    public static final By CONTINUE_BUTTON = By.id("continue");
    public static final By TOTAL_PRICE = By.cssSelector(".summary_total_label");
    public static final By FINISH_BUTTON = By.id("finish");
    public static final By CONFIRMATION_MESSAGE = By.cssSelector(".complete-header");


    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public void fillInCheckoutInfo(String firstName, String lastName, String postalCode) {
        driver.findElement(FIRST_NAME_INPUT).sendKeys(firstName);
        driver.findElement(LAST_NAME_INPUT).sendKeys(lastName);
        driver.findElement(POSTAL_CODE_INPUT).sendKeys(postalCode);
        driver.findElement(CONTINUE_BUTTON).click();
    }

    public String getTotalPrice() {
        return driver.findElement(TOTAL_PRICE).getText();
    }

    public void finishCheckout() {
        driver.findElement(FINISH_BUTTON).click();
    }

    public String getConfirmationMessage() {
        return driver.findElement(CONFIRMATION_MESSAGE).getText();
    }
}
