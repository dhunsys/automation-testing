package testng.dependencies;

import org.testng.annotations.Test;

import java.lang.reflect.Method;

/**
 * you can specify your group dependencies in the testng.xml file. You use the <dependencies> tag to achieve this:
 * The <depends-on> attribute contains a space-separated list of groups.
 * Make a note that group name is case sensitive
 * Problem : From below tests define a dependency in xml suite where c is dependent on a and d. Run group c
 *
 * SUITE FILE : dependencies_in_xml_suite.xml
 */
public class DependenciesInXmlTest {

    @Test(groups = "a")
    public void xml_dependencies_group_a_test(Method method) {
        System.out.println("I am test method : " + method.getName());
    }

    @Test(groups = "b")
    public void xml_dependencies_group_b_test(Method method) {
        System.out.println("I am test method : " + method.getName());
    }

    @Test(groups = "c")
    public void xml_dependencies_group_c_test(Method method) {
        System.out.println("I am test method : " + method.getName());
    }

    @Test(groups = "d")
    public void xml_dependencies_group_d_test(Method method) {
         System.out.println("I am test method : " + method.getName());
    }
}
