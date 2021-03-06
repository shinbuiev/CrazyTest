package Pages;

import Tests.BaseTest;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static Listeners.EventHandler.LOG;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by Dmitriy.F on 02.11.2016.
 */
public abstract class BasePage {
    private static  EventFiringWebDriver eventDriver;
    //----Top menu -------------------------------------


    //--------------------------------------------------------------

    public BasePage(EventFiringWebDriver eventDriver) {
        PageFactory.initElements(eventDriver, this);
        this.eventDriver = eventDriver;
        eventDriver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        LOG.info("Go to page \"" + eventDriver.getTitle().split("\\|")[0] + "\" with URL (" + eventDriver.getCurrentUrl() + ")");

    }


    public void waitForElement(WebElement element) {
        new WebDriverWait(eventDriver, 10).until(ExpectedConditions.visibilityOf(element));
    }


    public void randomClick(List<WebElement> list) {
        try {
            list.get((int) (Math.random() * list.size())).click();
        } catch (Exception e) {
        }
    }


    //---------Screenshot method----------------------------------------------------------------------------
    public static void takeScreen(EventFiringWebDriver recDriver, String eoorMess) {
        try {
            String date = new SimpleDateFormat("yyyy-MM-dd HH.mm.ss ").format(new Date());
            File screenS = recDriver.getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(screenS, new File("C:\\Automation\\chromedriver\\Screen\\" + BaseTest.testName + "\\" + eoorMess + "(" + date + ").jpg"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static Object createProduct() throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Object obj = null;
        String strUrl = eventDriver.getCurrentUrl().toLowerCase().replace("-","");
        String list[] = new File("src\\test\\java\\Products").list();
        for(int i=0;i<list.length;i++){
            list[i]=list[i].replace(".java","");
        }
        for (int i = 0; i < list.length; i++) {
            if (strUrl.contains(list[i].toLowerCase().trim())) {
                Class c = Class.forName("Products."+list[i]);
                obj = c.newInstance();
                break;
            }
        }
        return obj;
    }

//---------Screenshot method-------------------------------------------------------------------------------



}
