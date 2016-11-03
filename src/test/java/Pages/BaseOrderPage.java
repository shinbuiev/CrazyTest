package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

/**
 * Created by Dmitriy.F on 03.11.2016.
 */
public abstract class BaseOrderPage extends BasePage {
    private EventFiringWebDriver eventDriver;

    public BaseOrderPage(EventFiringWebDriver eventDriver) {
        super(eventDriver);
    }
}
