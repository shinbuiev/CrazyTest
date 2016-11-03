package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.util.List;

/**
 * Created by Dmitriy.F on 03.11.2016.
 */
public  class OrderPage extends BasePage {
    private EventFiringWebDriver eventDriver;

    @CacheLookup
    @FindBy(className = "main-title")
    private WebElement mainTitle;
    @CacheLookup
    @FindBy(css = ".g-custom-radio._no-label")
    private List<WebElement> termRadiobuttons;
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
    @FindBy(id = "total")
    private WebElement total;
    @CacheLookup
    @FindBy(className = "button_continue_order")
    private WebElement continueOrderButton;

    public OrderPage(EventFiringWebDriver eventDriver) {
        super(eventDriver);
        this.eventDriver=eventDriver;
    }

    public RegisterPage  orderProduct(String osName,String domainName){
        randomClick(termRadiobuttons);
        if(osName.equals("linux")) {
            randomClick(yourLocation);
        }if (planName.getText().equals("Business") && addonsCheckboxes.size()!=3){
            System.out.println("Incorrect Business addons number");
            return null;
        }else if(!planName.getText().equals("Business") && addonsCheckboxes.size()!=5 ){
            System.out.println("Incorrect  addons number");
            return null;
        }else for (int x = (int) (Math.random()*(addonsCheckboxes.size()-1));x<addonsCheckboxes.size()-1;x++) {
            randomClick(addonsCheckboxes);
        }
        randomClick(own_new_domainRadiobutton);
        own_new_domainField.sendKeys(domainName);
        continueOrderButton.click();

        return new RegisterPage(eventDriver);
    }
}
