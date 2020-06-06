package testng.listeners;

import org.testng.IAlterSuiteListener;
import org.testng.xml.*;

import java.util.ArrayList;
import java.util.List;

public class MyAlterSuiteListener implements IAlterSuiteListener {
    @Override
    public void alter(List<XmlSuite> suites) {
        suites.get(0).setName("New Suite Name");
        XmlInclude xmlInclude = new XmlInclude();
        xmlInclude.setName("alter_suite_listener_test2");
        //Add new test method at 2nd place
        suites.get(0).getTests().get(0).getClasses().get(0).getIncludedMethods().add(1, xmlInclude);

    }
}
