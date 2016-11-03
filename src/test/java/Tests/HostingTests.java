package Tests;

import DataProviders.DataProviders;
import Listeners.EventHandler;
import Pages.BuyPage;
import Pages.OrderPage;
import Pages.RegisterPage;
import Pages.ShoppingCartPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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
            System.setProperty("webdriver.chrome.driver", "/home/frunoyman/Загрузки/chromedriver");
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
        RegisterPage registerPage=orderPage.orderProduct(os,domainName);
        ShoppingCartPage shoppingCartPage=registerPage.goToShoppingCart();

    }

    @AfterMethod // If any test crashed - take screenshot and write ERROR message in log file
    public void takeScreenShotOnFailure(ITestResult testResult) throws IOException {

    }

    @AfterTest
    public void testEnding(){
        driver.quit();
    }


    }

