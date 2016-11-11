package Tests;

import DataProviders.DataProviders;
import Pages.BuyPage;
import Pages.LoginPage;
import Pages.OrderPage;
import Pages.ShoppingCartPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Iliia.Z on 05-Nov-16.
 */
public class WebSiteBuilderMembersTest extends BaseTest{

    @BeforeTest
    public void start(){
        initial();
        LoginPage lp = new LoginPage(getEventDriver());// open Login page
        lp.login2members("buster28", "Herpar8l");
    }

    @BeforeMethod
    public void getPage(){
        getEventDriver().get("https://manage.crazydomains.com.au/members/web-builder/order/");
//        getEventDriver().get("https://www.crazydomains.com.au/web-builder/");

    }

    @Test (dataProviderClass = DataProviders.class,dataProvider = "websitebuilderProvider")
    public void successWebSiteBuilderBuy(int buyNowButton,int planNumber, int pagesNumber, String domainName) {
        BuyPage buyPage = new BuyPage(getEventDriver());
        buyPage.selectPagesNumber(planNumber, pagesNumber);
        OrderPage orderPage = buyPage.buyPlan(buyNowButton);
        orderPage.checkingTerm();
        orderPage.chooseAddons();
        orderPage.fillFailedDomainName();
        orderPage.fillCorrectDomainName();
        orderPage.orderProduct();
        ShoppingCartPage shopCart = new ShoppingCartPage(getEventDriver());
        shopCart.emptyShoppingCart();
    }

    @Test
    public void getTooltips() {
        Map<String, String> tooltips = new HashMap<String, String>();
        BuyPage buyPage = new BuyPage(getEventDriver());
        List<WebElement> tooltipsButtons = getEventDriver().findElements(By.xpath(".//*[contains(@class, 'description linkTip tooltip')]"));
        for (WebElement tooltipsButton : tooltipsButtons) {
            if (tooltipsButton.isDisplayed()){
            tooltipsButton.click();

            }
        }
    }
}
