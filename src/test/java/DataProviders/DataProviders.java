package DataProviders;

import org.testng.annotations.DataProvider;

/**
 * Created by Dmitriy.F on 02.11.2016.
 */
public class DataProviders {

    public static String[] failedDomainNames={"папамама.ру","@!#%$^^*&(.com","gsdgeee.molodets",
    "dsddddd.dddd.ddddddddd.ddddddd.ddddd","\">","","     ","f"};


    public static Object correctDomainNameGenerator(){
        String[]words={"dsdsdas","hghgh","awfxaa","ssghte","rrawsw","sdrfrr","asdawdw","awyuiii","juttrr","drrrs","det5ww",
                "keeper","strong","little","nirvana","fallout"};
        String[]tld={".com",".net",".games",};
        return words[(int) (Math.random()*words.length)]+words[(int) (Math.random()*words.length)]+tld[(int) (Math.random()*tld.length)];
    }


    @DataProvider(name = "provider")
    public static Object[][] Provider(){
        return new Object[][]{
                {"linux",0,DataProviders.correctDomainNameGenerator()},
                {"linux",2,DataProviders.correctDomainNameGenerator()},
                {"linux",4,DataProviders.correctDomainNameGenerator()},
                {"windows",0,DataProviders.correctDomainNameGenerator()},
                {"windows",2,DataProviders.correctDomainNameGenerator()},
                {"windows",4,DataProviders.correctDomainNameGenerator()}
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

    @DataProvider(name = "websitebuilderProvider")
    public static Object[][] websitebuilderProvider(){
        return new Object[][]{
                {0, 1, 1, DataProviders.correctDomainNameGenerator()},
                {1, 1, 2, DataProviders.correctDomainNameGenerator()},
                {4, 2, 1,  DataProviders.correctDomainNameGenerator()},
                {5, 2, 2, DataProviders.correctDomainNameGenerator()},
                {8, 3, 1, DataProviders.correctDomainNameGenerator()},
                {9, 3, 2, DataProviders.correctDomainNameGenerator()}
        };
    }

}
