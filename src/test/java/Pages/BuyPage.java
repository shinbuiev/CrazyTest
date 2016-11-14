package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import static Listeners.EventHandler.LOG;

import java.util.List;

/**
 * Created by root on 03.11.16.
 */
public  class BuyPage extends BasePage {
    private EventFiringWebDriver eventDriver;

    @CacheLookup
    @FindBy(xpath = ".//*[@id='moving_object_container']/div/div/main/div/.//a[1]")
    private List<WebElement> buyPlanButton;
    @CacheLookup
    @FindBy(xpath = ".//*[@id='moving_object_container']/div/div/main/div/.//a[2]")
    private List<WebElement> webBuilderHideBuyPlanButton;
    @CacheLookup
    @FindBy(className = "linux")
    private WebElement linuxButton;
    @CacheLookup
    @FindBy(className = "windows")
    private WebElement windowsButton;
    @CacheLookup
    @FindBy(className = "menuItemContent")
    private List<WebElement> trafficBoosPages;
    @CacheLookup
    @FindBy(className = "more_info_btn")
    private WebElement moreButton;
    @CacheLookup
    @FindBy(xpath = ".//*/div/div/div/ul/li/div/div/div/div[2]/div")
    private List<WebElement> webSiteBuilderOption;
    @CacheLookup
    @FindBy(className = "selectWrap")
    private List<WebElement> webSiteBuilderDropdown;
    @CacheLookup
    @FindBy(css = ".plan-header>.col-title:first-child")
    private List<WebElement> productTitlePP;
    @CacheLookup
    @FindBy(xpath = ".//*[@id='moving_object_container']/div/div/div/ul[1]/li[1]")
    private List<WebElement> planSpecification;


    public BuyPage(EventFiringWebDriver eventDriver) {
        super(eventDriver);
        this.eventDriver = eventDriver;
    }

    public OrderPage buyPlan(int plan) {
        LOG.info("Start buying \"" + productTitlePP.get(plan)
                .getText() + " " + planSpecification.get(plan).getText().replace("\n", " ") + "\" plan");
        if(buyPlanButton.get(plan).isDisplayed()){
            buyPlanButton.get(plan).click();
        }else if(webBuilderHideBuyPlanButton.get(plan).isDisplayed()) {
            webBuilderHideBuyPlanButton.get(plan).click();
        }
        return new OrderPage(eventDriver);
    }

    //---------SWITCHER SECTION-----------------------------
    public void switchButton(int switchToAnother, int plan) {
        String curURL = eventDriver.getCurrentUrl();
        if (switchToAnother == 1) {
            if (curURL.contains("web-hosting")) {
                windowsButton.click();
                LOG.info("Switch to Windows Hosting");
            } else if (curURL.contains("web-builder")) {
                    webSiteBuilderDropdown.get(plan).click();
                    webSiteBuilderOption.get(0).click();
                    LOG.info("Switch to \"" + planSpecification.get(plan / 4).getText() + "\"");
            }
        }
    }
}
    //---------SWITCHER SECTION-----------------------------








