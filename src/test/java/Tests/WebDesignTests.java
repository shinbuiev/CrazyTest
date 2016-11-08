package Tests;

import DataProviders.DataProviders;
import Listeners.EventHandler;
import Pages.BuyPage;
import Pages.OrderPage;
import Pages.RegisterPage;
import Pages.ShoppingCartPage;
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
public class WebDesignTests extends BaseTest {


    @BeforeTest
    public void start(){
        initial();
    }

    @BeforeMethod
    public void getPage(){
        getEventDriver().get("https://www.crazydomains.com.au/web-design/");
    }

    @org.testng.annotations.Test(dataProviderClass = DataProviders.class,dataProvider = "provider")
    public void successProductBuy(String os,int planNumber,String domainName){
        BuyPage buyPage=new BuyPage(getEventDriver());
        OrderPage orderPage=buyPage.buyPlan(planNumber);
        orderPage.chooseTerm();
        orderPage.chooseAddons();
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
