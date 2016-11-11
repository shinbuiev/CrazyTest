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
                {0,0},
                {0,1},
                {0,2},
                {1,0},
                {1,1},
                {1,2}
        };
    }

    @DataProvider(name = "plans")
    public static Object[][] plans(){
        return new Object[][]{
                {0},
                {1},
                {2}
        };
    }

}
