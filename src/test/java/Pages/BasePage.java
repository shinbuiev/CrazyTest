package Pages;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by Dmitriy.F on 02.11.2016.
 */
public abstract class BasePage {
    private EventFiringWebDriver eventDriver;



    //----Top menu -------------------------------------



    //--------------------------------------------------------------

    public BasePage(EventFiringWebDriver eventDriver) {
        PageFactory.initElements(eventDriver,this);
        this.eventDriver = eventDriver;
        eventDriver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
    }


    public void waitForElement(WebElement element) {
        new WebDriverWait(eventDriver,5).until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForElementIsClickable (WebElement element) {
        new WebDriverWait(eventDriver,15).until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitForElementIsInvisible (WebElement element) {
        new WebDriverWait(eventDriver,15).until(ExpectedConditions.stalenessOf(element));
    }

    public void waitForTitle(String s) {
        new WebDriverWait(eventDriver,15).until(ExpectedConditions.urlContains(s));
    }


    public void randomClick(List<WebElement> list){
        try {
            list.get((int) (Math.random() * list.size())).click();
        }catch (Exception e){
        }
    }



}
