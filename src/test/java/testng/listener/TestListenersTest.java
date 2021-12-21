package testng.listener;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import testng.listeners.MyTestListener;

@Listeners({MyTestListener.class})
public class TestListenersTest {

    int count = 0;

    @Test
    public void test1() {
        System.out.println("Executing test1");
    }

    @Test
    public void test2() {
        Assert.assertEquals(1, 2);
    }

    /*
    Default successPercentage % is 100 i.e if a test runs n times it must pass n times to be considered as pass
    Here we are running this test 4 times where it passes 2 times and fails 2 times. So pass count=2 and fail count=2
    so to mark it pass we should put minimum 'successPercentage' =(passing count/4)*100 =(2/4)*100=50
    Also 60% of 4=2.4 so for 'successPercentage' 60, all test will be marked as passed (2.4 is considered as 2 and it is <=pass count)
    Again 70% of 4=2.8 so for 'successPercentage' 70, all test will be marked as passed (2.8 is considered as 2 and it is <=pass count)
    Again 74% of 4=2.96 so for 'successPercentage' 74, all test will be marked as passed (2.96 is considered as 2 and it is <=pass count)
    Again 75% of 4=3 so for 'successPercentage' 75, one of the test will be marked as failed because (3(expected passed test)>2(Actual pass test)
     */
    @Test(invocationCount = 4, successPercentage = 50)
    public void test_with_success_percentage50() {
        count++;
        System.out.println("count % 2 = " + count % 2);
        Assert.assertEquals(count % 2, 1); //success if "count" is an odd number
    }
}
