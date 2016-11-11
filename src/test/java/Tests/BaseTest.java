package Tests;

import Listeners.EventHandler;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.internal.Coordinates;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by Dmitriy.F on 07.11.2016.
 */
public abstract class BaseTest {
    private WebDriver driver;
    private EventFiringWebDriver eventDriver;
    public static String testName;


    public void initial(){
        testName=this.getClass().getName();
        System.setProperty("webdriver.chrome.driver", "C:\\Automation\\chromedriver\\chromedriver.exe");
        driver=new ChromeDriver();

        eventDriver=new EventFiringWebDriver(driver);

        eventDriver.manage().window().setSize(new Dimension(1080, 1520));
        eventDriver.manage().window().setPosition(new Point(2560, -120));
//        eventDriver.manage().window().maximize();
        eventDriver.register(new EventHandler("#FFFF00", 1, 300, TimeUnit.MILLISECONDS));
    }

    public WebDriver getDriver() {
        return driver;
    }

    public EventFiringWebDriver getEventDriver() {
        return eventDriver;
    }
}
