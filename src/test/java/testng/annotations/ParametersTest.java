package testng.annotations;

import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import selenium.Drivers;

public class ParametersTest extends Drivers {


    @Parameters({"suite_level_param", "test_level_param"})
    @Test()
    public void param1_test(String slp, String tlp) {

        System.out.println("Suite level parameter value--> " + slp + ", Test level parameter1 value--> " + tlp);

    }

    @Parameters({"suite_level_param", "test_level_param"})
    @Test()
    public void param2_test(String slp, String tlp) {

        System.out.println("Suite level parameter value--> " + slp + ", Test level parameter2 value--> " + tlp);

    }

    /*
    Run directly from here or xml suite (without below parameters) to see the default value
     */
    @Parameters({"suite_level_param", "test_level_param"})
    @Test()
    public void default_param_test(@Optional("default-slp") String slp, @Optional("default-tlp") String tlp) {

        System.out.println("Suite level parameter value--> " + slp + ", Test level parameter1 value--> " + tlp);

    }
//    @Parameters({"suite_level_param"})
//    @BeforeSuite()
//    public void beforeSuite(String slp){
//        System.out.println("Inside before suite----Suite level parameter value--> "+slp);
//    }

//    @Parameters({"test_level_param"})
//    @BeforeTest()
//    public void beforeTest(String tlp){
//        System.out.println("Inside before test----test level parameter value--> "+tlp);
//    }
}
