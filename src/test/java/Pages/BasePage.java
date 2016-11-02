package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by Dmitriy.F on 02.11.2016.
 */
public abstract class BasePage {
    private WebDriver driver;

    private String baseURL="https://manage.crazydomains.com.au/members/";

    //----Top menu -------------------------------------



    //--------------------------------------------------------------

    public BasePage(WebDriver driver) {
        PageFactory.initElements(driver,this);
        this.driver = driver;
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
    }


    public void waitForElement(WebElement element) {
        new WebDriverWait(driver,15).until(ExpectedConditions.visibilityOf(element));
    }

    public boolean isElementExist(WebElement element){
        try {
            waitForElement(element);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public void randomClick(List<WebElement> list){
        list.get((int) (Math.random()*(list.size()-1))).click();
    }


    public void createProduct() {

    return ;
    }
}
