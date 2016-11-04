package DataProviders;

import org.testng.annotations.DataProvider;

/**
 * Created by Dmitriy.F on 02.11.2016.
 */
public class DataProviders {

    public static Object correctDomainNameGenerator(){
        String[]words={"dsdsdas","hghgh","awfxaa","ssghte","rrawsw","sdrfrr","asdawdw","awyuiii","juttrr","drrrs","det5ww",
                "keeper","strong","little","nirvana","fallout"};
        String[]tld={".com",".net",".au",".games",};
        return words[(int) (Math.random()*words.length)]+words[(int) (Math.random()*words.length)]+tld[(int) (Math.random()*tld.length)];
    }

    @DataProvider(name = "hostingProvider")
    public static Object[][] hostingProvider(){
        return new Object[][]{
                {"linux",0,DataProviders.correctDomainNameGenerator()},
                {"linux",2,DataProviders.correctDomainNameGenerator()},
                {"linux",4,DataProviders.correctDomainNameGenerator()},
                {"windows",0,DataProviders.correctDomainNameGenerator()},
                {"windows",2,DataProviders.correctDomainNameGenerator()},
                {"windows",4,DataProviders.correctDomainNameGenerator()}
        };
    }
}
