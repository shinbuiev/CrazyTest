package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.util.List;

/**
 * Created by root on 03.11.16.
 */
public  class BuyPage extends BasePage{
    private EventFiringWebDriver eventDriver;

    @CacheLookup
    @FindBy(className = "withLoading")
    private List<WebElement> buyPlanButton;
    @CacheLookup
    @FindBy(className = "linux")
    private WebElement linuxButton;
    @CacheLookup
    @FindBy(className = "windows")
    private WebElement windowsButton;
    @CacheLookup
    @FindBy(className = "menuItemContent")
    private List<WebElement> trafficBoosPages;


    public BuyPage(EventFiringWebDriver eventDriver) {
        super(eventDriver);
        this.eventDriver=eventDriver;
    }

    public OrderPage buyPlan(int plan){
        buyPlanButton.get(plan).click();
        return new OrderPage(eventDriver);
    }

    public BuyPage selectHostingOs(String osName){
        if (osName.equals("linux")){
            linuxButton.click();
        }else if(osName.equals("windows")){
            windowsButton.click();
        }
        return this;
    }
}
