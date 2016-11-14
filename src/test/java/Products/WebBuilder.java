package Products;

import static Listeners.EventHandler.LOG;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

/**
 * Created by Dmitriy.F on 14.11.2016.
 */
public class WebBuilder extends Product {

    private final String[] webBuilderName={"My Site","Site Plus","Site Pro"};
    private final String[] webBuilderAddons={"Traffic Booster","Premium Email Protection"};
    private final int[] webBuilderTerms={12,24,48,84};

    public WebBuilder() {
        assertTrue(getName(webBuilderName));
        assertEquals(webBuilderTerms,getTerms());
        assertEquals(webBuilderAddons,getAddons());
        LOG.info("Product WebBuilder create");
    }


}
