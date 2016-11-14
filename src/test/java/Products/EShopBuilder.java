package Products;

import static Listeners.EventHandler.LOG;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

/**
 * Created by Dmitriy.F on 14.11.2016.
 */
public class EShopBuilder extends Product {

    private final String[] eshopNames={"eShop","eShop PLUS","eShop PRO"};
    private final String[] eshopAddons={"Traffic Booster","Premium Email Protection"};
    private final int[] eshopTerms={12,24,48,84};

    public EShopBuilder() {
        assertTrue(getName(eshopNames),"Name not equal for EShopBuilder");
        assertEquals(eshopAddons,getAddons(),"Addons not equal");
        assertEquals(eshopTerms,getTerms(),"Term not equal");
        LOG.info("Product EShopBuilder create");
    }


}
