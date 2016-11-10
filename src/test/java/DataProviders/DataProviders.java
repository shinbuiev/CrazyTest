package DataProviders;

import org.testng.annotations.DataProvider;

/**
 * Created by Dmitriy.F on 02.11.2016.
 */
public class DataProviders {

    public static String[] failedDomainNames={"папамама.ру","@!#%$^^*&(.com",
    "\">","","     ","f"};


    public static String corrDomainGenerator(){
        String[]words={"dsdsdas","hghgh","awfxaa","ssghte","rrawsw","sdrfrr","asdawdw","awyuiii","juttrr","drrrs","det5ww",
                "keeper","strong","little","nirvana","fallout"};
        String[]tld={".com",".net",".com.au",};
        return words[(int) (Math.random()*words.length)]+words[(int) (Math.random()*words.length)]+tld[(int) (Math.random()*tld.length)];
    }


    @DataProvider(name = "provider")
    public static Object[][] Provider(){
        return new Object[][]{
                {"linux",0},
                {"linux",2},
                {"linux",4},
                {"windows",0},
                {"windows",2},
                {"windows",4}
        };
    }

    @DataProvider(name = "plans")
    public static Object[][] plans(){
        return new Object[][]{
                {0},
                {2},
                {4}
        };
    }

}
