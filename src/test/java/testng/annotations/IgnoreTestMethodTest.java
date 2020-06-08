package testng.annotations;

import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

/**
 * @ignore on top of a test method tells testng to ignore that test method
 * RUN this class directly to see one test method with ignore annotation is not executed
 */
public class IgnoreTestMethodTest {

    @Test()
    public void demo_test1(Method method) {
        System.out.println("I am not ignored : " + method.getName());
    }

    @Ignore
    @Test()
    public void demo_test2(Method method) {
        System.out.println("I am ignored : " + method.getName());
    }
}
