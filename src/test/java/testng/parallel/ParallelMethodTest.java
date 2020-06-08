package testng.parallel;

import org.testng.annotations.Test;

/**
 * ------------------------------Example-1---------------------------------------------------
 * TestNG has default thread-count is : 5
 * By default TestNG runs tests serially
 * Lets run example1_suite.xml suite and observe.
 * All tests are run serially as per they organized in suite file.
 * All tests are run by one thread. Observe the thread id printed is same for every test
 * Thread count doesn't matters in serial execution
 * ------------------------------------Example-2----------------------------------------------
 * Lets run suite 'example2_suite.xml'
 * This suite sets the 'parallel' attribute to 'methods'. That means all methods in suite will run in parallel
 * Observe the order of test executions. Tests are picked randomly.
 * Observe the thread id for each test, it is different.
 * To maintain order use 'dependsonMethod. If test3 depends on 'test2' then TestNG will run 'test2' first then
 * it may or may not other tests in suite before executing 'test3'. Run suite multiple times to see this effect
 * -----------------------------------------Example-3----------------------------------------------------
 * Lets run suite 'example3_suite.xml'
 * This suite has 6 test methods. As we know default thread-count is 5. To run 6 test methods in parallel with 5 threads,
 * two of the methods will be executed by one thread.
 * ---------------------------------Example-4-------------------------------------------------------------
 * Lets run suite 'example4_suite.xml'
 * In 'example-3' we knew that due to lack of thread any two methods executed by same thread.
 * Executing multiple code by same thread sometimes produce data inconsistency.
 * Use 'thread-count' to match with the no of methods. Here we set 'thread-count=6' so that 6 test methods will run by unique threads
 *-----------------------------------------Example-5-------------------------------------------------------
 * */
public class ParallelMethodTest {

    @Test
    public void test1(){
        System.out.println("test1 is executed by thread "+Thread.currentThread().getId());
    }

    @Test
    public void test2(){
        System.out.println("test2 is executed by thread "+Thread.currentThread().getId());
    }
    @Test()
    public void test3(){
        System.out.println("test3 is executed by thread "+Thread.currentThread().getId());
    }
    @Test
    public void test4(){
        System.out.println("test4 is executed by thread "+Thread.currentThread().getId());
    }
    @Test
    public void test5(){
        System.out.println("test5 is executed by thread "+Thread.currentThread().getId());
    }
    @Test
    public void test6(){
        System.out.println("test6 is executed by thread "+Thread.currentThread().getId());
    }
}
