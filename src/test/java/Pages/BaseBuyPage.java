package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.util.List;

/**
 * Created by root on 03.11.16.
 */
public abstract class BaseBuyPage extends BasePage{
    private EventFiringWebDriver eventDriver;

    @FindBy(className = "withLoading")
    private List<WebElement> buyPlanButton;


    public BaseBuyPage(EventFiringWebDriver eventDriver) {
        super(eventDriver);
        this.eventDriver=eventDriver;
    }

    public BaseOrderPage buyPlan(int plan){
        buyPlanButton.get(plan).click();
        return new OrderHostingPage(eventDriver);
    }
}
