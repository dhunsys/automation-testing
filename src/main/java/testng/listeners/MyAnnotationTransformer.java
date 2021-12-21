package testng.listeners;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;
import testng.dataprovider.DataProviderFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.Arrays;

public class MyAnnotationTransformer implements IAnnotationTransformer {
    @Override
    public void transform(
            ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
        if (testMethod.getName()=="annotationTransformerTest3") {
            String grps[]= new String[] { "regression" };
            annotation.setGroups(grps);
            System.out.println("groups after change : "+ Arrays.toString(annotation.getGroups()));

        }
        if (testMethod.getName().equals("add_data_provider_run_time_test")) {
            System.out.println("set data provider for " + testMethod.getName());
            annotation.setDataProviderClass(DataProviderFactory.class);
            annotation.setDataProvider("myDp");

        } else if (testMethod.getName().equals("disable_run_time_test")) {
            System.out.println("Disable " + testMethod.getName());
            annotation.setEnabled(false);
        }
    }

}
