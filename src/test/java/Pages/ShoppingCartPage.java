package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

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
    @CacheLookup
    @FindBy(id = "cart_control")
    private WebElement cartControl;
    @FindBy(name = "Submit")
    private WebElement checkoutButtonMembers;
    @FindBy (xpath = ".//*[@id='shopping_cart_table']/div/div[2]/a")//as is, normal id for this
    private WebElement startAgain;
    @FindBy (id = "cart_control")
    private WebElement upCart;
    @FindBy (className = "crazyPopUp_container")
    private WebElement popupEmpty;




    private WebElement checkEmptyShopCart;
    public ShoppingCartPage(EventFiringWebDriver eventDriver) {
        super(eventDriver);
        this.eventDriver=eventDriver;
        if (eventDriver.getCurrentUrl().contains("members")){
            eventDriver.get("https://manage.crazydomains.com.au/members/shopping-cart/");
            waitForElement(checkoutButtonMembers);
        }
        else
            waitForElement(checkoutButton);
    }

    public void emptyShoppingCart(){
        if (buttonEmptyCart.isDisplayed()) {
            buttonEmptyCart.click();
            waitForElement(cartResetButton);
            cartResetButton.click();
            waitForElementIsInvisible(eventDriver.findElement(By.className("crazyPopUp_container")));// with using @FindBy get error(
            waitForElementIsClickable(upCart);
        }
    }
}
