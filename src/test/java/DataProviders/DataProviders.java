package DataProviders;

import org.testng.annotations.DataProvider;

/**
 * Created by Dmitriy.F on 02.11.2016.
 */
public class DataProviders {
    @DataProvider(name = "hostingProvider")
    public static Object[][] failedLoginData(){
        return new Object[][]{
                {"linux",0},
                {"linux",2},
                {"linux",4},
                {"windows",0},
                {"windows",2},
                {"windows",4}
        };
    }
}
