package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.events.EventFiringWebDriver;

/**
 * Created by Iliia.Z on 05-Nov-16.
 */
public class PaymentPage extends BasePage {
    private EventFiringWebDriver eventDriver;

    @FindBy (name = "Submit")
    private WebElement payAndActive;

    public PaymentPage(EventFiringWebDriver eventDriver) {
        super(eventDriver);
        this.eventDriver=eventDriver;
    }
}
