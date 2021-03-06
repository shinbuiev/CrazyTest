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

import static org.testng.Assert.assertTrue;

/**
 * Created by root on 06.11.16.
 */
public class EmailMarketingTests extends BaseTest{

    @BeforeTest
    public void start(){
        initial();
    }

    @BeforeMethod
    public void getPage(){
        getEventDriver().get("https://www.crazydomains.com.au/email-marketing/");
    }

    @Test(dataProviderClass = DataProviders.class,dataProvider = "plans")
    public void successProductBuy(int planNumber) throws IllegalAccessException, ClassNotFoundException, InstantiationException {
        BuyPage buyPage=new BuyPage(getEventDriver());
        OrderPage orderPage=buyPage.buyPlan(planNumber);
        orderPage.checkingTerm();
        RegisterPage registerPage=orderPage.orderProduct();
        ShoppingCartPage shoppingCartPage=registerPage.goToShoppingCart();
        shoppingCartPage.emptyShoppingCart();
    }


    @AfterTest
    public void testEnding(){
        getDriver().quit();
    }
}
