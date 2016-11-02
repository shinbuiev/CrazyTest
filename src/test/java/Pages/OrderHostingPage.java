package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;


/**
 * Created by Dmitriy.F on 02.11.2016.
 */
public class OrderHostingPage extends BasePage {
    private WebDriver driver;

    @CacheLookup
    @FindBy(className = "button_continue_order")
    private WebElement continueButton;

    public OrderHostingPage(WebDriver driver) {
        super(driver);
        this.driver=driver;
        waitForElement(continueButton);
    }


}
