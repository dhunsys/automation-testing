package testng.listener;

import org.testng.annotations.Test;

/**
 * This test to be run from suite xml as listeners are supplied in xml suite
 */
public class TestListenerXMLTest {

    @Test
    public void test_listener1_xml_test() {
        System.out.println("Listener in XML suite  test");
    }
}
