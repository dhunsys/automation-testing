package testng.dependencies;

import org.testng.annotations.Test;

import java.lang.reflect.Method;

/**
 * Hard dependencies==>All the methods you depend on must have run and succeeded for you to run.
 * If at least one failure occurred in your dependencies, you will not be invoked and marked as a SKIP in the report.
 * Hard dependencies is default by testng
 * Make sure if a test method depends on multiple other test methods, all dependent methods must be included in given test method or suite if any
 * Here 'hard_dependencies_test' is depending on ["depend_on_me1_test","depend_on_me2_test","depend_on_fail_test"] where
 * 'depend_on_fail_test' is failed forcefully so due to hard dependency we get following output :
 * 'hard_dependencies_test' ===>skipped
 * 'depend_on_me1_test' ===>skipped
 * 'depend_on_me2_test' ===>skipped
 * 'depend_on_fail_test' ===>failed
 *
 *  RUN 'hard_dependencies_test' or 'hard_dependencies_suite.xml
 *  ---------------------------------------------------------------------------------
 *  NOTE-Same concept is applied on test groups
 */
public class HardDependenciesTest {

    @Test(dependsOnMethods = {"depend_on_me1_test", "depend_on_me2_test", "depend_on_fail_test"})
    public void hard_dependencies_test(Method method) {
        System.out.println("I am test method : " + method.getName());
    }

    @Test(dependsOnMethods = "depend_on_fail_test")
    public void depend_on_me1_test(Method method) {
        System.out.println("I am test method : " + method.getName());
    }

    @Test(dependsOnMethods = "depend_on_fail_test")
    public void depend_on_me2_test(Method method) {
        System.out.println("I am test method : " + method.getName());
    }

    @Test
    public void depend_on_fail_test(Method method) {
        int x = 5 / 0;
        System.out.println("I am test method : " + method.getName());
    }
}
