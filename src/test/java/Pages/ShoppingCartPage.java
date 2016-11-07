package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.events.EventFiringWebDriver;

/**
 * Created by Dmitriy.F on 02.11.2016.
 */
public class ShoppingCartPage extends BasePage {
    private EventFiringWebDriver eventDriver;

    @CacheLookup
    @FindBy(className = "check_out_button")
    private WebElement checkoutButton;
    @CacheLookup
    @FindBy(className = "buttonEmptyCart")
    private WebElement buttonEmptyCart;
    @CacheLookup
    @FindBy(id = "cart_reset")
    private WebElement cartResetButton;

    public ShoppingCartPage(EventFiringWebDriver eventDriver) {
        super(eventDriver);
        this.eventDriver=eventDriver;
        waitForElement(checkoutButton);
    }

    public void emptyShoppingCart(){
        buttonEmptyCart.click();
        waitForElement(cartResetButton);
        cartResetButton.click();
    }
}
