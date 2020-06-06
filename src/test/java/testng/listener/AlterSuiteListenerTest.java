package testng.listener;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * This Test illustrates how to alter a an xml suite at run time. Here we change suite name and add one more test method
 * Run 'alter_suite_listener_suite.xml' suite which include one test method 'alter_suite_listener_test1'.
 * At run time listener's alter() method gets called where we add 2nd test method 'alter_suite_listener_test2'
 * As a result two test method runs
 */
public class AlterSuiteListenerTest {

    @Test(description = "alter_suite_listener_description1")
    public void alter_suite_listener_test1() {

        System.out.println("alter suite_listener_test1");

    }

    @Test(description = "alter_suite_listener_description2")
    public void alter_suite_listener_test2() {

        System.out.println("alter suite_listener_test2");

    }
}
