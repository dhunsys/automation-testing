package testng.listeners;

import org.testng.*;

import java.util.Map;

public class MySuiteListener implements ISuiteListener {

    @Override
    public void onStart(ISuite suite) {
        System.out.println("ON START=>Suite details------------------------------------");
        System.out.println("Suite Name '" + suite.getName());
        System.out.println("Xml Suite Name '" + suite.getXmlSuite().getName());
        System.out.println("Xml Suite Tests count '" + suite.getXmlSuite().getTests().size());
        System.out.println("Xml Suite File Name '" + suite.getXmlSuite().getFileName());
        System.out.println("Xml Suite Data provider thread count '" + suite.getXmlSuite().getDataProviderThreadCount());
        System.out.println("Xml Suite Parallel '" + suite.getXmlSuite().getParallel().name());
        for (ITestNGMethod name : suite.getAllMethods()) {
            System.out.println("-----------------------ON START=>Test Method details--------------------------");
            System.out.println("Test method :" + name.getQualifiedName());
            System.out.println("Test method description:" + name.getDescription());
            System.out.println("-----------------------ON START=>Test Method details ends---------------------------");
        }

    }

    @Override
    public void onFinish(ISuite suite) {
        System.out.println("ON Finish Suite details ===============================================");
        System.out.println("Suite Name '" + suite.getName() + "' finished");
        System.out.println("Xml Suite Tests count '" + suite.getXmlSuite().getTests().size());
        System.out.println("Xml Suite File Name '" + suite.getXmlSuite().getFileName());
        System.out.println("Suite state Failed ? '" + suite.getSuiteState().isFailed());
        System.out.println("Suite Methods count '" + suite.getAllMethods().size());
        System.out.println("Total results count : " + suite.getResults().size());

        Map<String, ISuiteResult> results = suite.getResults();
        for (Map.Entry<String, ISuiteResult> map : results.entrySet()) {
            System.out.println("--------ON FINISH=>Suite Results Details starts-------------");

            System.out.println("Xml Suite name : " + map.getValue().getTestContext().getCurrentXmlTest().getName());
            System.out.println("Passed tests count : " + map.getValue().getTestContext().getPassedTests().getAllMethods().size());
            System.out.println("Failed tests count : " + map.getValue().getTestContext().getFailedTests().getAllMethods().size());
            System.out.println("Skipped tests count : " + map.getValue().getTestContext().getSkippedTests().getAllMethods().size());
            for (ITestResult result : map.getValue().getTestContext().getPassedTests().getAllResults()) {
                System.out.println("-------------------ON FINISH Passed Tests details------------");
                System.out.println("test Method name : " + result.getMethod().getQualifiedName());
                System.out.println("Status : " + result.getStatus());
            }
            for (ITestResult result : map.getValue().getTestContext().getFailedTests().getAllResults()) {
                System.out.println("-------------------ON FINISH Failed Tests details------------");
                System.out.println("test Method name : " + result.getMethod().getQualifiedName());
                System.out.println("Status : " + result.getStatus());
            }

            for (ITestResult result : map.getValue().getTestContext().getSkippedTests().getAllResults()) {
                System.out.println("-------------------ON FINISH Skipped Tests details------------");
                System.out.println("test Method name : " + result.getMethod().getQualifiedName());
                System.out.println("Status : " + result.getStatus());
            }
            System.out.println("--------ON FINISH=>Suite Results Details End-------------");

        }

    }

}
