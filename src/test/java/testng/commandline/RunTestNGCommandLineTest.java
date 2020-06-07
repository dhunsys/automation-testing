package testng.commandline;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import selenium.Drivers;

import java.lang.reflect.Method;

/**
 * Require to create project jar for both main+test packages. Use 'maven jar plugin'
 * Require tools' jars (including selenium,testng,db, etc). Use 'maven 'dependency plugin'. Put in 'libs' folder
 * Navigate to project target folder where project jars and libs folder are created
 * run command: java -cp <main.jar>:<test.jar>:<library folder>/* org.testng.TestNG <suite.xml>
 * e.g. java -cp automation-1.0-SNAPSHOT.jar:automation-1.0-SNAPSHOT-tests.jar:libs/* org.testng.TestNG /home/ms/projects/automation/suites/commandline/commandline_suite.xml
 * ------------------------------------------------------With -d option---------------------------------------------
 * Scenario: create test-output in folder 'ms' under project folder
 * java -cp automation-1.0-SNAPSHOT.jar:automation-1.0-SNAPSHOT-tests.jar:libs/* org.testng.TestNG -d ../ms /home/ms/projects/automation/suites/commandline/commandline_suite.xml
 * ----------------------------------------------------------methods-------------------------------------------------------
 * Scenario: run specific test method. Put fully qualified names separated by commas
 * java -cp automation-1.0-SNAPSHOT.jar:automation-1.0-SNAPSHOT-tests.jar:libs/* org.testng.TestNG -methods testng.commandline.RunTestNGCommandLineTest.command_line_pass_test
 * ------------------------------------listener-----------------------------------------------------------------------------
 * Allows you specify your own test listeners. The classes need to implement org.testng.ITestListener
 * java -cp automation-1.0-SNAPSHOT.jar:automation-1.0-SNAPSHOT-tests.jar:libs/* org.testng.TestNG -listener testng.listeners.MyTestListener -methods testng.commandline.RunTestNGCommandLineTest.command_line_pass_test
 * -----------------------------------------parallel-------------------------------------------------
 * If specified, sets the default mechanism used to determine how to use parallel threads when running tests. If not set, default mechanism is not to use parallel threads at all. This can be overridden in the suite definition.
 * java -cp automation-1.0-SNAPSHOT.jar:automation-1.0-SNAPSHOT-tests.jar:libs/* org.testng.TestNG -parallel methods -methods testng.commandline.RunTestNGCommandLineTest.command_line_pass_test,testng.commandline.RunTestNGCommandLineTest.command_line_fail_test
 * Run once or more to see parallel run effect. Do not run suite xml as suite file override command line parallel value
 * * ------------------------------------------------configfailurepolicy----------------------------------------------
 * -configfailurepolicy:Whether TestNG should continue to execute the remaining tests in the suite or skip them if an @Before* method fails. Default behavior is skip.
 * java -cp automation-1.0-SNAPSHOT.jar:automation-1.0-SNAPSHOT-tests.jar:libs/* org.testng.TestNG -configfailurepolicy skip /home/ms/projects/automation/suites/commandline/config_failure_policy_suite.xml
 * Check skip count must be 1
 * configfailurepolicy=continue is not working:
 * java -cp automation-1.0-SNAPSHOT.jar:automation-1.0-SNAPSHOT-tests.jar:libs/* org.testng.TestNG -configfailurepolicy continue /home/ms/projects/automation/suites/commandline/config_failure_policy_suite.xml
 *
 * SUITE FILE USED : commandline_suite.xml/config_fail_policy_suite.xml
 *
 */
public class RunTestNGCommandLineTest extends Drivers {
    int i = 0;

    @BeforeMethod
    public void beforeMethod() {
        //used for passing 'configfailurepolicy' parameter
        if (i == 1) {
            int b = i / 0;
        }
    }

    @Test
    public void command_line_pass_test(Method method) {
        System.out.println("Command line TEST METHOD : " + method.getName());
    }

    @Test
    public void command_line_fail_test(Method method) {
        System.out.println("Command line TEST METHOD : " + method.getName());
        Assert.assertEquals(1, 2);
    }

    @Test
    public void command_line_config_fail_policy_pass_test(Method method) {
        //next test will be skipped as i value is changed to 1 so before method will fail and configfailurepolicy is set to true
        i = 1;
    }

    @Test
    public void command_line_config_fail_policy_skip_test(Method method) {
        System.out.println("Command line TEST METHOD : " + method.getName());
    }
}
