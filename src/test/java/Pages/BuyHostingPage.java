package Pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.util.List;

/**
 * Created by Dmitriy.F on 02.11.2016.
 */
public class BuyHostingPage extends BasePage {
    private EventFiringWebDriver eventDriver;

    @CacheLookup
    @FindBy(className = "linux")
    private WebElement linuxButton;
    @CacheLookup
    @FindBy(className = "windows")
    private WebElement windowsButton;
    @CacheLookup
    @FindBy(className = "withLoading")
    private List<WebElement> buyPlanButton;





    public BuyHostingPage(EventFiringWebDriver eventDriver) {
        super(eventDriver);
        this.eventDriver=eventDriver;
        waitForElement(linuxButton);
    }

    public BuyHostingPage selectHostingOs(String osName){
        if (osName.equals("linux")){
            linuxButton.click();
        }else if(osName.equals("windows")){
            windowsButton.click();
        }
        return this;
    }

    public OrderHostingPage buyHostingPlan(int plan){
        buyPlanButton.get(plan).click();
        return new OrderHostingPage(eventDriver);
    }



}
