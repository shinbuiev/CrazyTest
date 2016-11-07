package Listeners;


import Pages.BasePage;
import Tests.BaseTest;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.LogManager;
import org.openqa.selenium.*;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.apache.log4j.Logger;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Dmitriy.F on 03.11.2016.
 */
public class EventHandler implements WebDriverEventListener {
    private String path="";
    private static final Logger LOG = LogManager.getLogger(EventHandler.class);
    private WebElement element;
    private WebDriver driver;
    private String testName;


    public void beforeNavigateTo(String s, WebDriver webDriver) {

        LOG.info("Start running  "+ BaseTest.testName+ " and go to link- "+s);
        driver=webDriver;
    }

    public void afterNavigateTo(String s, WebDriver webDriver) {

    }

    public void beforeNavigateBack(WebDriver webDriver) {

    }

    public void afterNavigateBack(WebDriver webDriver) {

    }

    public void beforeNavigateForward(WebDriver webDriver) {

    }

    public void afterNavigateForward(WebDriver webDriver) {

    }

    public void beforeNavigateRefresh(WebDriver webDriver) {

    }

    public void afterNavigateRefresh(WebDriver webDriver) {

    }

    public void beforeFindBy(By by, WebElement webElement, WebDriver webDriver) {

    }

    public void afterFindBy(By by, WebElement webElement, WebDriver webDriver) {
    path= String.valueOf(by);

    }

    public void beforeClickOn(WebElement webElement, WebDriver webDriver) {

    }

    public void afterClickOn(WebElement webElement, WebDriver webDriver) {
    element=webElement;
    }

    public void beforeChangeValueOf(WebElement webElement, WebDriver webDriver) {
        LOG.info("Start changing WebElement @FindBy(\""+path+"\")");
    }

    public void afterChangeValueOf(WebElement webElement, WebDriver webDriver) {
        LOG.info("WebElement @FindBy(\""+path+"\") changed value to \'"+webElement.getAttribute("value")+"\'");

    }

    public void beforeScript(String s, WebDriver webDriver) {
    }

    public void afterScript(String s, WebDriver webDriver) {
    }

    public void onException(Throwable throwable, WebDriver webDriver) {
        LOG.error("Running test stop at WebElement "+element);
        try {
            recordStep();
        } catch (AWTException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

//---------Screenshot method---------------------------------------------------------------------
    public  void recordStep() throws AWTException, IOException {

        String date = new SimpleDateFormat("yyyy-MM-dd HH.mm.ss ").format(new Date());
        File screenS = ((TakesScreenshot)(driver)).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenS, new File("C:\\Automation\\chromedriver\\Screen\\"+BaseTest.testName+"\\"+element.getAttribute("class")+date+".jpg"));
    }
//---------Screenshot method---------------------------------------------------------------------
}
