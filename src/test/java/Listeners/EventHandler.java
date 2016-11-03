package Listeners;


import org.apache.log4j.LogManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;
import org.apache.log4j.Logger;

import java.io.File;

/**
 * Created by Dmitriy.F on 03.11.2016.
 */
public class EventHandler implements WebDriverEventListener {
    private String path="";
    private static final Logger LOG = LogManager.getLogger(EventHandler.class);


    public void beforeNavigateTo(String s, WebDriver webDriver) {
    LOG.info("Go to link- "+s);
    }

    public void afterNavigateTo(String s, WebDriver webDriver) {

    }

    public void beforeNavigateBack(WebDriver webDriver) {

    }

    public void afterNavigateBack(WebDriver webDriver) {

    }

    public void beforeNavigateForward(WebDriver webDriver) {
        LOG.info("Go to link- "+webDriver);
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
        LOG.info("Should click WebElement - \'"+ webElement.getText()+"\', @FindBy(\""+path+"\")");
    }

    public void afterClickOn(WebElement webElement, WebDriver webDriver) {
        LOG.info("Clicked successfull");
    }

    public void beforeChangeValueOf(WebElement webElement, WebDriver webDriver) {
        LOG.info("Start changing WebElement \'"+webElement.getAttribute("name")+"\'");
    }

    public void afterChangeValueOf(WebElement webElement, WebDriver webDriver) {
        LOG.info("WebElement \'"+webElement.getAttribute("name")+"\' changed value to \'"+webElement.getAttribute("value")+"\'");
    }

    public void beforeScript(String s, WebDriver webDriver) {

    }

    public void afterScript(String s, WebDriver webDriver) {

    }

    public void onException(Throwable throwable, WebDriver webDriver) {

    }
}
