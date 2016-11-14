package Products;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * Created by Dmitriy.F on 02.11.2016.
 */
public abstract class Product {

    @CacheLookup
    @FindBy(css = ".bold.item-name")
    public List<WebElement> addonsDescription;
    @CacheLookup
    @FindBy(css = ".item-name>span")
    private List<WebElement> termDate;
    @CacheLookup
    @FindBy(css = ".plan-spec-square")
    private WebElement planSpec;

    public boolean getName(String[]names) {
        boolean planEqual=false;
        for (int x=0;x<names.length;x++){
            if (names[x].equals(planSpec.getText())){
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
