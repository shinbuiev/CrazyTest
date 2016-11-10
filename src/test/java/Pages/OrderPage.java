package Pages;

import DataProviders.DataProviders;
import org.openqa.selenium.NoSuchElementException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.util.List;

import static DataProviders.DataProviders.failedDomainNames;
import static org.testng.Assert.assertTrue;


/**
 * Created by Dmitriy.F on 03.11.2016.
 */
public  class OrderPage extends BasePage {
    private EventFiringWebDriver eventDriver;


    @CacheLookup
    @FindBy(className = "main-title")
    private WebElement mainTitle;
    @CacheLookup
    @FindBy(xpath = ".//*[@id='crazy_order_webbuilder_form']/div[1]/div[2]/div/div/div/div/input")
    private List<WebElement> inputsTermRadiobuttons;
    @FindBy(css = ".g-custom-radio._no-label")
    private List<WebElement> termRadiobuttons;
    @CacheLookup
    @FindBy(css = "._between>._hover>.order_table_row_js")
    private List<WebElement> termFields;
    @CacheLookup
    @FindBy(className = "plan-title-square")
    private WebElement planName;
    @CacheLookup
    @FindBy(className = "select-server-box")
    private List<WebElement> yourLocation;
    @CacheLookup
    @FindBy(className = "g-custom-checkbox")
    private List<WebElement>addonsCheckboxes;
    @CacheLookup
    @FindBy(css = ".bold.item-name")
    private List<WebElement>addonsDescription;
    @CacheLookup
    @FindBy(xpath = ".//*[@id='connect_to']/div[2]/div/div[2]/div[1]/div/div")
    private List<WebElement>own_new_domainRadiobutton;
    @CacheLookup
    @FindBy(id = "search_domain_input")
    private WebElement own_new_domainField;
    @CacheLookup
    @FindBy(className = "website_protection_domain")
    private WebElement webSiteProtectionField;
    @CacheLookup
    @FindBy(id = "total")
    private WebElement total;
    @CacheLookup
    @FindBy(className = "button_continue_order")
    private WebElement continueOrderButton;
    @CacheLookup
    @FindBy(className = "requiredField")
    private WebElement errorField;

    public OrderPage(EventFiringWebDriver eventDriver) {
        super(eventDriver);
        this.eventDriver=eventDriver;
    }

    public void chooseLinuxLocation(){
        randomClick(yourLocation);
    }

    public void chooseTerm(){
        randomClick(termFields);
    }

    public void chooseAddons(){
        for (int x = (int) (Math.random()*(addonsCheckboxes.size()));x<addonsCheckboxes.size();x++) {
            addonsCheckboxes.get(x).click();
        }
    }

    public void chooseNewDomain(){
        own_new_domainRadiobutton.get(1).click();
    }

    public void fillDomainNameField(String domainName){
        try {
            own_new_domainField.sendKeys(domainName);
        }catch (NoSuchElementException e){
            webSiteProtectionField.sendKeys(domainName);
        }
    }

    public void fillFailedDomainName(){
    for(int x=0;x<failedDomainNames.length;x++){
        try {
            own_new_domainField.clear();
            own_new_domainField.sendKeys(failedDomainNames[x]);
            own_new_domainField.submit();
        }catch (NoSuchElementException e){
            webSiteProtectionField.clear();
            webSiteProtectionField.sendKeys(failedDomainNames[x]);
            webSiteProtectionField.submit();
        }
        assertTrue(isErrorUpear());
    }
    }

    public boolean isErrorUpear(){
        boolean appear=false;
        try {
            waitForElement(errorField);
            return appear=true;
        }catch (Exception e){
           return appear=false;
        }
    }

    public RegisterPage  orderProduct(){
        continueOrderButton.click();
        return new RegisterPage(eventDriver);
    }

}
