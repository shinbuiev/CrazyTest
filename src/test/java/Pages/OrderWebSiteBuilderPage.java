package Pages;

import org.openqa.selenium.support.events.EventFiringWebDriver;

/**
 * Created by root on 03.11.16.
 */
public class OrderWebSiteBuilderPage extends BaseOrderPage {
    private EventFiringWebDriver eventDriver;

    public OrderWebSiteBuilderPage(EventFiringWebDriver eventDriver) {
        super(eventDriver);
    }
}
