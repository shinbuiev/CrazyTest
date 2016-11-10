package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.events.EventFiringWebDriver;

/**
 * Created by Iliia.Z on 05-Nov-16.
 */
public class LoginPage extends BasePage {
    private EventFiringWebDriver eventDriver;

    @FindBy (id = "username")
    private WebElement userenameField;
    @FindBy (id = "member_password")
    private WebElement passwordField;
    @FindBy (partialLinkText = "/login/domain-name-forgot-password/")
    private WebElement lostPassword;

    public LoginPage(EventFiringWebDriver eventDriver) {
        super(eventDriver);
        this.eventDriver=eventDriver;
        eventDriver.get("https://www.crazydomains.com.au/login/domain-name-login/");
        waitForElement(passwordField);
    }


    public EventFiringWebDriver login2members(String username, String password) {
        userenameField.sendKeys(username);
        passwordField.sendKeys(password);
        passwordField.submit();
        waitForTitle("members");
        return this.eventDriver;
    }
}
