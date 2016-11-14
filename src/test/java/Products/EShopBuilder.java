package Products;

import org.openqa.selenium.support.PageFactory;
import static Listeners.EventHandler.LOG;
import static Tests.BaseTest.eventDriver;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

/**
 * Created by Dmitriy.F on 14.11.2016.
 */
public class EShopBuilder extends Product {

    private final String[] eshopNames={"My Site","Site Plus","Site Pro"};
    private final String[] eshopAddons={"Traffic Booster","Premium Email Protection"};
    private final int[] eshopTerms={12,24,48,84};

    public EShopBuilder() {
        PageFactory.initElements(eventDriver,this);
        assertTrue(getName(eshopNames),"Name not equal for EShopBuilder");
        assertEquals(eshopAddons,getTerms());
        assertEquals(eshopTerms,getAddons());
        LOG.info("Product EShopBuilder create");
    }


}
