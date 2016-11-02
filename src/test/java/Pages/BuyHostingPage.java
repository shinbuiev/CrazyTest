package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * Created by Dmitriy.F on 02.11.2016.
 */
public class BuyHostingPage extends BasePage {
    private WebDriver driver;
    @CacheLookup
    @FindBy(className = "linux")
    private WebElement linuxButton;
    @CacheLookup
    @FindBy(className = "windows")
    private WebElement windowsButton;
    @CacheLookup
    @FindBy(className = "withLoading")
    private List<WebElement> buyPlanButton;



    public BuyHostingPage(WebDriver driver) {
        super(driver);
        this.driver=driver;
        waitForElement(linuxButton);
    }




}
