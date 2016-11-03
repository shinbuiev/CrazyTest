package Pages;

import DataProviders.DataProviders;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.util.List;


/**
 * Created by Dmitriy.F on 02.11.2016.
 */
public class OrderHostingPage extends BaseOrderPage {
    private EventFiringWebDriver eventDriver;

    @CacheLookup
    @FindBy(className = "button_continue_order")
    private WebElement continueOrderButton;

    public OrderHostingPage(EventFiringWebDriver eventDriver) {
        super(eventDriver);
        this.eventDriver=eventDriver;
        waitForElement(continueOrderButton);
    }




}
