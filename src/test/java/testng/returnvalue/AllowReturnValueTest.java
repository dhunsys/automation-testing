package testng.returnvalue;

import org.testng.ISuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

/**
 * If I run this test method no test were found will be the result.
 * As per testng a method with return value is not considered as test.
 * To tell testng to consider it as a test, one need to set 'allow-return-value' to true
 * Set 'allow-return-values=true' in suite file at either suite or test level
 * SUITE FILE USED : allow_return_value_suite.xml
 *
 */
public class AllowReturnValueTest {

    @Test()
    public int allow_return_value_test(Method method) {
        System.out.println("I will not run if allow return value is set to false : " + method.getName());
        return 100;

    }


}
