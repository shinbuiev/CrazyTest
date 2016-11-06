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
public class WebDesignTests {
    private EventFiringWebDriver eventDriver;
    private WebDriver driver;

    @BeforeTest
    public void initial(){
        System.setProperty("webdriver.chrome.driver", "/home/frunoyman/Загрузки/chromedriver");
        DesiredCapabilities capabilities=new DesiredCapabilities();
        capabilities.setCapability(CapabilityType.PAGE_LOAD_STRATEGY,"eager");
        driver=new ChromeDriver();
        eventDriver=new EventFiringWebDriver(driver);
        eventDriver.register(new EventHandler());
        eventDriver.manage().window().maximize();
    }

    @BeforeMethod
    public void getPage(){
        eventDriver.get("https://www.crazydomains.com.au/web-design/");
    }

    @org.testng.annotations.Test(dataProviderClass = DataProviders.class,dataProvider = "hostingProvider")
    public void successHostingBuy(String os,int planNumber,String domainName){
        BuyPage buyPage=new BuyPage(eventDriver);
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
        driver.quit();
    }
}
