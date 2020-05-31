package testng.listener;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import testng.listeners.MySuiteListener;

@Listeners(MySuiteListener.class)
class SuiteListenerTest {

    @Test(groups = "g1",description = "suite_listener_description1")
    public void suite_listener_test1() {
        System.out.println("suite_listener_test1");
    }
    @Test(groups = "g2",description = "suite_listener_description2")
    public void suite_listener_test2() {
        System.out.println("suite_listener_test2");
        Assert.assertEquals(1,2);
    }

}
