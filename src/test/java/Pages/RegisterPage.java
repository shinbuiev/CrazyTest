package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * Created by Dmitriy.F on 02.11.2016.
 */
public class RegisterPage extends BasePage {
    private WebDriver driver;

    @CacheLookup
    @FindBy(id="login_submit_button")
    private WebElement registrationLoginButton;
    @CacheLookup
    @FindBy(className = "step-title")
    private List<WebElement> orderStepLine;

    public RegisterPage(WebDriver driver) {
        super(driver);
        this.driver=driver;
        waitForElement(registrationLoginButton);
    }

    public ShoppingCartPage goToShoppingCart(){
        orderStepLine.get(0).click();
        return new ShoppingCartPage(driver);
    }
}
