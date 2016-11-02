package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Dmitriy.F on 02.11.2016.
 */
public class ShoppingCartPage extends BasePage {
    private WebDriver driver;

    @CacheLookup
    @FindBy(className = "check_out_button")
    private WebElement checkoutButton;

    public ShoppingCartPage(WebDriver driver) {
        super(driver);
        this.driver=driver;
        waitForElement(checkoutButton);
    }
}
