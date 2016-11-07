package Tests;

import DataProviders.DataProviders;
import Listeners.EventHandler;
import Pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

/**
 * Created by root on 06.11.16.
 */
public class SiteProtectionTests extends BaseTest{


    @BeforeTest
    public void start(){
        initial();
    }

    @BeforeMethod
    public void getPage(){
        getEventDriver().get("https://www.crazydomains.com.au/website-protection/");
    }

    @org.testng.annotations.Test(dataProviderClass = DataProviders.class,dataProvider = "hostingProvider")
    public void successHostingBuy(String os,int planNumber,String domainName){
        BuyPage buyPage=new BuyPage(getEventDriver());
        OrderPage orderPage=buyPage.buyPlan(planNumber*0);
        orderPage.chooseTerm();
        orderPage.fillDomainNameField(domainName);
        RegisterPage registerPage=orderPage.orderProduct();
        ShoppingCartPage shoppingCartPage=registerPage.goToShoppingCart();
        shoppingCartPage.emptyShoppingCart();

    }


    @AfterTest
    public void testEnding(){
        getDriver().quit();
    }
}
