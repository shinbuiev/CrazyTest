package Products;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static Listeners.EventHandler.LOG;
import static Tests.BaseTest.eventDriver;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

/**
 * Created by Dmitriy.F on 14.11.2016.
 */
public class EShopBuilder implements Product {

    @CacheLookup
    @FindBy(css = ".bold.item-name")
    public List<WebElement> addonsDescription;
    @CacheLookup
    @FindBy(css = ".item-name>span")
    private List<WebElement> termDate;
    @CacheLookup
    @FindBy(css = ".plan-spec-square")
    private WebElement planSpec;


    private final String[] webBuilderName={"My Site","Site Plus","Site Pro"};
    private final String[] webBuilderAddons={"Traffic Booster","Premium Email Protection"};
    private final int[] webBuilderTerms={12,24,48,84};

    public EShopBuilder() {
        PageFactory.initElements(eventDriver,this);
        assertTrue(getName());
        assertEquals(webBuilderTerms,getTerms());
        assertEquals(webBuilderAddons,getAddons());
        LOG.info("Product EShopBuilder create");
    }

    public boolean getName() {
        boolean planEqual=false;
        for (int x=0;x<webBuilderName.length;x++){
            if (webBuilderName[x].equals(planSpec.getText())){
                planEqual=true;
                break;
            }
        }
        return planEqual;
    }

    public String[] getAddons() {
        String[]addon=new String[addonsDescription.size()];
        for (int x=0;x<addonsDescription.size();x++){
            addon[x]=addonsDescription.get(x).getText();
        }
        return addon;
    }

    public int[] getTerms() {
        int[]term=new int[termDate.size()];
        for (int x=0;x<termDate.size();x++){
            term[x]= Integer.parseInt(termDate.get(x).getText());
        }
        return term;
    }
}
