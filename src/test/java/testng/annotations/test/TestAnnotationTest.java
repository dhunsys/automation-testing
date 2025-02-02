
package testng.annotations.test;

import org.testng.annotations.Test;
import testng.dataprovider.DataProviderFactory;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

public class TestAnnotationTest {

    @Test()
    public void simple_test() {
        System.out.println("@Test Demo");
    }

    @Test(description = "Short summary of this test")
    public void description_test() {

        System.out.println("description attribute Demo");

    }

    @Test(enabled = false, description = " false tells test not to run")
    public void enabled_test() {

        System.out.println("enabled is false so I will not print");

    }

    @Test(invocationCount = 5, description = " The number of times this method should be invoked. ")
    public void invocation_count_test() {

        System.out.println("Invocation count");

    }

    @Test(invocationTimeOut = 5000, invocationCount = 5, description = "The maximum number of milliseconds this test should take for the cumulated time of all the invocationcounts. This attribute will be ignored if invocationCount is not specified. ")
    public void invocation_count_timeout_test() throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("Invocation count with timeout");

    }

    @Test(timeOut = 10, description = "The maximum number of milliseconds this test should take. ")
    public void time_out_fail_test() throws InterruptedException {
        Thread.sleep(10);// as timeout equals sleep time test fails
        System.out.println("time out");

    }

    @Test(description = "Which thread executes this test")
    public void time_out_pass_test() throws InterruptedException {
        System.out.println("Thread Name : "+ Thread.currentThread().getName());

    }

    @Test(threadPoolSize = 3, invocationCount = 5, description = "The size of the thread pool for this method. The method will be invoked from multiple threads as specified by invocationCount.\n" +
            "Note: this attribute is ignored if invocationCount is not specified ")
    public void thread_pool_size_test() {
        System.out.println("Thread pool size: Thread Name is-> " + Thread.currentThread().getName());

    }

    //by default all test have 0 priority. Lets create a test with priority < 0 so that it will run first
    @Test(priority = -1, description = "The priority for this test method. Lower priorities will be scheduled first. ")
    public void priority_0_test() throws InterruptedException {
        System.out.println("Lowest Priority test runs first");
        Thread.sleep(3000);

    }

    @Test(groups = "DEMO", description = "The list of groups this class/method belongs to. ")
    public void test_group_test(Method method) {
        System.out.println("Test group is-> " + method.getAnnotation(Test.class).groups()[0]);

    }

    @Test(dependsOnGroups = "DEMO", description = "The list of groups this method depends on. ")
    public void depends_on_groups_test() {
        System.out.println("Print after dependent groups finish");

    }

    @Test(dependsOnMethods = "simple_test", description = "The list of methods this method depends on. ")
    public void depends_on_methods_test() {
        System.out.println("Print after dependent methods finish");

    }

    @Test(expectedExceptions = {ArithmeticException.class}, description = "The list of exceptions that a test method is expected to throw. If no exception or a different than one on this list is thrown, this test will be marked a failure.  ")
    public void expected_exception_pass_test() {

        int x = 5 / 0;

    }

    @Test(expectedExceptions = {ArrayIndexOutOfBoundsException.class}, description = "The list of exceptions that a test method is expected to throw. If no exception or a different than one on this list is thrown, this test will be marked a failure.  ")
    public void expected_exception_fail_test() {

        int x = 5 / 0;

    }

    @Test(alwaysRun = false, dependsOnMethods = "expected_exception_fail_test", description = "if set to true, this test method will always be run even if it depends on a method that failed.  ")
    public void always_run_false_test() {

        System.out.println("I will not print because alwaysRun is false and my dependent one is failed");

    }

    @Test(alwaysRun = true, dependsOnMethods = "expected_exception_fail_test", description = "if set to true, this test method will always be run even if it depends on a method that failed.  ")
    public void always_run_true_test() {

        System.out.println("I will run because alwaysRun is true and even its dependent one is failed");

    }




    @Test(dataProvider = "2DReturnType",
            dataProviderClass = DataProviderFactory.class)
    public void data_provider_2d(Object[] x) {
        System.out.println(x[0] +"="+x[1]);
    }
    @Test(dataProvider = "myDp",
            dataProviderClass = DataProviderFactory.class)
    public void data_provider_map(Map<String,String> student) {
        System.out.println(student.get("name")+"="+student.get("roll"));
    }
    /*
    Rows are fetched in the order as appear in database
     */
    @Test(dataProvider = "platformDp", dataProviderClass = DataProviderFactory.class, description = "The name of the data provider for this test method. ")
    public void data_provider_sequential_test(Map<String,Object> platform) {

        System.out.println("os------>" + platform.get("os") + " version--------> " + platform.get("version"));

    }

    /*
    Rows are fetched randomly. If see sequential, run one more time to see difference
     */
    @Test(dataProvider = "platformDp1", dataProviderClass = DataProviderFactory.class, description = "The name of the data provider for this test method. ")
    public void data_provider_Parallel_test(Map<String,Object> platform) {

        System.out.println("os------>" + platform.get("os") + " version--------> " + platform.get("version"));

    }
}
