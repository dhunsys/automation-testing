package testng.dependencies;

import org.testng.annotations.Test;

import java.lang.reflect.Method;

/**
 * Soft dependencies==>it will always be run after the methods you depend on, even if some of them have failed.
 * This is useful when you just want to make sure that your test methods are run in a certain order but their success doesn't really depend on the success of others.
 * A soft dependency is obtained by adding "alwaysRun=true" in your @Test annotation.
 * Make sure if a test method depends on multiple other test methods, all dependent methods must be included in given test method
 * Here 'hard_dependencies_test' is depending on ["depend_on_me1_test","depend_on_me2_test","depend_on_fail_test"] where
 * 'depend_on_fail_test' is failed forcefully so due to soft dependency we get following output :
 *
 * 'depend_on_fail_test' ===>failed
 * 'depend_on_me1_test' ===>skipped
 * 'depend_on_me2_test' ===>skipped
 * 'soft_dependencies_test' ===>pass
 *
 *  RUN 'soft_dependencies_test' or 'soft_dependencies_suite.xml'
 *  ----------------------------------------------------------------------------------------
 *  NOTE-Same concept is applied on test groups
 */
public class SoftDependenciesTest {

    @Test(alwaysRun = true,dependsOnMethods = {"depend_on_me1_test", "depend_on_me2_test", "depend_on_fail_test"})
    public void soft_dependencies_test(Method method) {
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
