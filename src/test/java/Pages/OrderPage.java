package Pages;

import DataProviders.DataProviders;
import Listeners.EventHandler;
import org.openqa.selenium.NoSuchElementException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.util.ArrayList;
import java.util.List;

import static DataProviders.DataProviders.corrDomainGenerator;
import static DataProviders.DataProviders.failedDomainNames;
import static Listeners.EventHandler.*;
import static Listeners.EventHandler.LOG;
import static org.testng.Assert.*;


/**
 * Created by Dmitriy.F on 03.11.2016.
 */
public  class OrderPage extends BasePage {
    private EventFiringWebDriver eventDriver;

    //--------Order Page WebElements ------------------------------
    @CacheLookup
    @FindBy(className = "main-title")
    private WebElement mainTitle;                                   //-
    @CacheLookup
    @FindBy(css = "._between>._hover>.order_table_row_js")
    private List<WebElement> termFields;
    @CacheLookup
    @FindBy(css = ".item-name>span")
    private List<WebElement> termDate;
    @CacheLookup
    @FindBy(css = ".g-custom-radio>.product_element")
    private List<WebElement> inputsTermRadiobuttons;
    @CacheLookup
    @FindBy(xpath = ".//span[2][@class='price-promo']")
    private List<WebElement> termPromoCost;
    @CacheLookup
    @FindBy(css = "span.price-now:first-of-type")
    private List<WebElement> termCost;
    @CacheLookup
    @FindBy(className = "plan-title-square")
    private WebElement planName;
    @CacheLookup
    @FindBy(className = "select-server-box")
    private List<WebElement> yourLocation;
    @CacheLookup
    @FindBy(css = ".g-custom-checkbox>.product_element")
    private List<WebElement>addonsCheckboxes;
    @CacheLookup
    @FindBy(xpath = ".//div/div[@class='_hover col-xl-20 col-l-24']/div[@class='row table-row order_table_row_js']")
    private List<WebElement>addonsFields;
    @CacheLookup
    @FindBy(css = ".bold.item-name")
    private List<WebElement>addonsDescription;
    @CacheLookup
    @FindBy(xpath = ".//*[@id='connect_to']/div[2]/div/div[2]/div[1]/div/div")
    private List<WebElement>own_new_domainRadiobutton;
    @CacheLookup
    @FindBy(css = ".input>input")
    private WebElement domainField;
    @CacheLookup
    @FindBy(css = "span#total")
    private WebElement total;
    @CacheLookup
    @FindBy(className = "button_continue_order")
    private WebElement continueOrderButton;
    @CacheLookup
    @FindBy(css = ".input>.requiredField")
    private WebElement errorField;
    @CacheLookup
    @FindBy(className = "globalTip")
    private List<WebElement> toolTops;

    //--------Order Page WebElements ------------------------------

    //--------Constructor  ------------------------------
    public OrderPage(EventFiringWebDriver eventDriver) {
        super(eventDriver);
        this.eventDriver=eventDriver;
    }
    //--------Constructor  ------------------------------

    //--------Choose Location for Hosting Provider  ------------------------------
    public void chooseLinuxLocation(){
        randomClick(yourLocation);
    }
    //--------Choose Location for Hosting Provider  ------------------------------

    //--------Check all Terms/Cost(promo) , changing total  ------------------------------
    public void checkingTerm() {
        int count = 0;
        int term = 0;
        double cost = 0;
        int expectedTotal = 0;
        int actualTotal = 0;
        while (count < termFields.size()) {
            termFields.get(count).click();
            if(!inputsTermRadiobuttons.get(count).isSelected()){
            takeScreen(eventDriver,"Plan option "+(termDate.get(count).getText())+" uncheckable");
            }
            assertTrue(inputsTermRadiobuttons.get(count).isSelected());
            LOG.info("RadioButton \""+termDate.get(count).getText()+" month\" is checked");
            term = Integer.parseInt(termDate.get(count).getText());
            if (termPromoCost.get(count).getText().equals("")) {
            cost = Double.parseDouble(termCost.get(count).getText().replace("$", "").replace("/mo", "").trim());
            } else
            cost = Double.parseDouble(termPromoCost.get(count).getText().replace("$", "").trim().replace("/mo", "").trim());
            expectedTotal = (int) Math.round(term * cost);
            actualTotal = Integer.parseInt(total.getText().trim().replace(".00", "").replace(",", ""));
            if (actualTotal!=expectedTotal){
            takeScreen(eventDriver,"Total not equals at Plan options "+term+" month");
            }
            assertEquals(actualTotal, expectedTotal);
            count++;
        }
    }
    //--------Check all Terms/Cost(promo) , changing total  ------------------------------

    //--------Check all Addons  ------------------------------
    public void chooseAddons(){
        int count=0;
        while (count<addonsFields.size()){
            addonsFields.get(count).click();
            if(!addonsCheckboxes.get(count).isSelected()){
                takeScreen(eventDriver,"Addon \""+addonsDescription.get(count).getText()+"\" not add to the product");
            }
            assertTrue(addonsCheckboxes.get(count).isSelected());
            LOG.info("Addon \""+addonsDescription.get(count).getText()+"\" is checked and add to the product");
            count++;

        }

    }
    //--------Check all Addons  ------------------------------

    //--------Choose New/Own Domain  ------------------------------
    public void chooseNewOrOwnDomain(int switcher){
        LOG.info("Switching for New or Own Domain");
        own_new_domainRadiobutton.get(switcher).click();
    }
    //--------Choose New/Own Domain  ------------------------------


    public void fillCorrectDomainName() {
            domainField.clear();
            domainField.sendKeys(corrDomainGenerator());
            LOG.info("Fill Domain name field for \"" + domainField.getAttribute("value") + "\"");
            total.click();
            assertFalse(isErrorAppear());
        }


    //--------Fill Domain name fields with failed names ------------------------------
    public void fillFailedDomainName() {
        for (int x = 0; x < failedDomainNames.length; x++) {
            domainField.clear();
            domainField.sendKeys(failedDomainNames[x]);
            domainField.submit();
            LOG.info("Fill failed Domain name field for \"" + failedDomainNames[x] + "\"");

            assertTrue(isErrorAppear());
        }
    }

    //--------Fill Domain name fields with failed names ------------------------------

    //--------Check is error message at Domain name field appear ------------------------------
    public boolean isErrorAppear(){
        boolean appear=false;
        try {
            waitForElement(errorField);
            return appear=true;
        }catch (Exception e){
           LOG.error("Domain name validation error message not appear!");
           takeScreen(eventDriver,"Domain name validation error message not appear!");
           return appear=false;
        }
    }
    //--------Check is error message at Domain name field appear ------------------------------


    //--------Click on Order Product button ------------------------------
    public RegisterPage  orderProduct(){
        continueOrderButton.click();
        LOG.info("Click \"Continue Oder\" button");
        return new RegisterPage(eventDriver);
    }
    //--------Click on Order Product button ------------------------------

}
