package Tests;

import DataProviders.DataProviders;
import Pages.BuyPage;
import Pages.OrderPage;
import Pages.RegisterPage;
import Pages.ShoppingCartPage;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

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

    @Test(dataProviderClass = DataProviders.class,dataProvider = "plans")
    public void successProductBuy(int planNumber,String domainName){
        BuyPage buyPage=new BuyPage(getEventDriver());
        OrderPage orderPage=buyPage.buyPlan(planNumber);
        orderPage.chooseTerm();
        orderPage.chooseAddons();
        orderPage.fillDomainNameField(domainName);
        RegisterPage registerPage=orderPage.orderProduct();
        ShoppingCartPage shoppingCartPage=registerPage.goToShoppingCart();
        shoppingCartPage.emptyShoppingCart();
    }

    @Test(dataProviderClass = DataProviders.class,dataProvider = "plans")
    public void failedProductBuy(int planNumber){
        BuyPage buyPage=new BuyPage(getEventDriver());
        OrderPage orderPage=buyPage.buyPlan(planNumber);
        orderPage.chooseTerm();
        orderPage.chooseAddons();
        orderPage.fillFailedDomainName();
    }


    @AfterTest
    public void testEnding(){
        getDriver().quit();
    }
}
