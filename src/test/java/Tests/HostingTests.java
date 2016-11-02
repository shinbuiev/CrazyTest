package Tests;

import DataProviders.DataProviders;
import Pages.BuyHostingPage;
import Pages.OrderHostingPage;
import Pages.RegisterPage;
import Pages.ShoppingCartPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;


/**
 * Created by Dmitriy.F on 02.11.2016.
 */
public class HostingTests {
    private WebDriver driver;

    @BeforeTest
    public void initial(){
            System.setProperty("webdriver.chrome.driver", "C:\\Automation\\chromedriver\\chromedriver.exe");
            driver=new ChromeDriver();
            driver.manage().window().maximize();
        }

    @BeforeMethod
    public void getPage(){
        driver.get("https://www.crazydomains.com.au/web-hosting/");
    }

    @org.testng.annotations.Test(dataProviderClass = DataProviders.class,dataProvider = "hostingProvider")
    public void successHostingBuy(String os,int planNumber,String domainName){
        BuyHostingPage buyHostingPage=new BuyHostingPage(driver);
        buyHostingPage.selectHostingOs(os);
        OrderHostingPage orderHostingPage=buyHostingPage.buyHostingPlan(planNumber);
        RegisterPage registerPage=orderHostingPage.orderHostingProduct(os,domainName);
        ShoppingCartPage shoppingCartPage=registerPage.goToShoppingCart();

    }

    @AfterMethod
    public void methodEnding (){

    }

    @AfterTest
    public void testEnding(){
        driver.quit();
    }


    }

