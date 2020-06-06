package testng.commandline;

import org.testng.Assert;
import org.testng.annotations.Test;
import selenium.Drivers;

import java.lang.reflect.Method;

/**
 * Require to create project jar for both main+test packages. Use 'maven jar plugin'
 * Require tools' jars (including selenium,testng,db, etc). Use 'maven 'dependency plugin'. Put in 'libs' folder
 * Navigate to project target folder where project jars and libs folder are created
 * run command: java -cp <main.jar>:<test.jar>:<library folder>/* org.testng.TestNG <suite.xml>
 * e.g. java -cp automation-1.0-SNAPSHOT.jar:automation-1.0-SNAPSHOT-tests.jar:libs/* org.testng.TestNG /home/ms/projects/automation/suites/commandline/commandline_suite.xml
 *------------------------------------------------------With -d option---------------------------------------------
 * Scenario: create test-output in folder 'ms' under project folder
 * java -cp automation-1.0-SNAPSHOT.jar:automation-1.0-SNAPSHOT-tests.jar:libs/* org.testng.TestNG -d ../ms /home/ms/projects/automation/suites/commandline/commandline_suite.xml
 */
public class RunTestNGCommandLineTest extends Drivers {

    @Test
    public void command_line_pass_test(Method method){
        System.out.println("Command line TEST METHOD : "+method.getName());
    }

    @Test
    public void command_line_fail_test(Method method){
        System.out.println("Command line TEST METHOD : "+method.getName());
        Assert.assertEquals(1,2);
    }
}
