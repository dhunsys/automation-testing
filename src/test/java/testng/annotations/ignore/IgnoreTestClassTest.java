
package testng.annotations.ignore;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

/**
 * @ignore on top of a test class tells testng to ignore that test class
 * RUN this class directly to see none of the test method executed. 'No test were found' is the result
 */
@Ignore
@Test()
public class IgnoreTestClassTest {
    @Test()
    public void demo_test1(Method method) {
        System.out.println("I am ignored : " + method.getName());
    }
    @Test()
    public void demo_test2(Method method) {
        System.out.println("I am ignored : " + method.getName());
    }
}
