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
    @FindBy(xpath = ".//*[@id='moving_object_container']/div/div/main/div/.//a")
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
    @CacheLookup
    @FindBy(className = "more_info_btn")
    private WebElement moreButton;
    @CacheLookup
    @FindBy(className = "menuItemContent")
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
        moreButton.click();
    }

    public OrderPage buyPlan(int plan) {
        LOG.info("Start buying \""+productTitlePP.get(plan).getText()+"\" plan");
        try{
            buyPlanButton.get(plan).click();
        }catch (Exception e){
            buyPlanButton.get(plan+1).click();
        }
        return new OrderPage(eventDriver);
    }

    //---------Web HOSTING SECTION-----------------------------
    public void selectHostingOs(String osName) {
       if (osName.equals("switch")) {
           LOG.info("Switch to Windows Hosting");
           windowsButton.click();
       }
    }
    //---------Web HOSTING SECTION-----------------------------


    //---------Web BUILDER SECTION-----------------------------
    public void selectBuilder(String sw, int plan) {
        if (sw.equals("windows")) {
            webSiteBuilderDropdown.get(plan / 2).click();
            webSiteBuilderOption.get(1).click();
            LOG.info("Switch to \""+planSpecification.get(plan/4).getText()+"\"");
        }

    }
    public void selectPagesNumber (int planNumber, int pagesNumber) {
        webSiteBuilderDropdown.get(planNumber-1).click();
        webSiteBuilderOption.get(pagesNumber-1).click();

    }
    //---------Web BUILDER SECTION-----------------------------
}
