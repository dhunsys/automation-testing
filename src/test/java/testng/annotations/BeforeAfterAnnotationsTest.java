package testng.annotations;

import org.testng.annotations.*;
import selenium.Drivers;

public class BeforeAfterAnnotationsTest extends Drivers {

    @Test(groups = "BEFORE-AFTER")
    public void beforeAfterTest(){
        System.out.println("In beforeAfterTest method");
    }
    @BeforeSuite()
    public void before_suite_test() {

        System.out.println("BEFORE-SUITE : The annotated method will be run before all tests in this suite have run. ");

    }

    @AfterSuite()
    public void after_suite_test() {

        System.out.println("AFTER SUITE : The annotated method will be run after all tests in this suite have run. ");

    }

    @BeforeTest()
    public void before_test() {

        System.out.println("BEFORE TEST : The annotated method will be run before any test method belonging to the classes inside the <test> tag is run. ");

    }

    @AfterTest()
    public void after_test() {

        System.out.println("AFTER TEST : The annotated method will be run after all the test methods belonging to the classes inside the <test> tag have run. ");

    }

    @BeforeGroups()
    public void before_groups_test() {

        System.out.println("BEFORE GROUP : The list of groups that this configuration method will run before. This method is guaranteed to run shortly before the first test method that belongs to any of these groups is invoked. ");

    }

    @AfterGroups()
    public void after_groups_test() {

        System.out.println("AFTER GROUP : The list of groups that this configuration method will run after. This method is guaranteed to run shortly after the last test method that belongs to any of these groups is invoked. ");

    }

    @BeforeClass()
    public void before_class_test() {

        System.out.println("BEFORE CLASS : The annotated method will be run before the first test method in the current class is invoked. ");

    }

    @AfterClass()
    public void after_class_test() {

        System.out.println("AFTER CLASS : The annotated method will be run after all the test methods in the current class have been run. ");

    }

    @BeforeMethod()
    public void before_method_test() {

        System.out.println("BEFORE METHOD : The annotated method will be run before each test method. ");

    }

    @AfterMethod()
    public void after_method_test() {

        System.out.println("AFTER METHOD : The annotated method will be run after each test method. ");

    }
}
