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
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import java.io.IOException;

import static org.apache.log4j.helpers.LogLog.error;


/**
 * Created by Dmitriy.F on 02.11.2016.
 */
public class HostingTests {
    private EventFiringWebDriver eventDriver;
    private WebDriver driver;

    @BeforeTest
    public void initial(){
            System.setProperty("webdriver.chrome.driver", "C:\\Automation\\chromedriver\\chromedriver.exe");
            driver=new ChromeDriver();
            eventDriver=new EventFiringWebDriver(driver);
            eventDriver.register(new EventHandler());
            eventDriver.manage().window().maximize();
        }

    @BeforeMethod
    public void getPage(){
        eventDriver.get("https://www.crazydomains.com.au/web-hosting/");
    }

    @org.testng.annotations.Test(dataProviderClass = DataProviders.class,dataProvider = "hostingProvider")
    public void successHostingBuy(String os,int planNumber,String domainName){
        BuyPage buyPage=new BuyPage(eventDriver);
        buyPage.selectHostingOs(os);
        OrderPage orderPage=buyPage.buyPlan(planNumber);
        orderPage.chooseTerm();
        orderPage.chooseLinuxLocation();
        orderPage.chooseAddons();
        orderPage.fillDomainNameField(domainName);
        RegisterPage registerPage=orderPage.orderProduct();
        ShoppingCartPage shoppingCartPage=registerPage.goToShoppingCart();
        shoppingCartPage.emptyShoppingCart();
    }


    @AfterTest
    public void testEnding(){
        driver.quit();
    }


    }

