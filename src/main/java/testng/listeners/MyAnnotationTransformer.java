package testng.listeners;

import org.testng.IAnnotationTransformer;
import org.testng.IAnnotationTransformer2;
import org.testng.annotations.IDataProviderAnnotation;
import org.testng.annotations.ITestAnnotation;
import testng.dataprovider.DataProviderFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class MyAnnotationTransformer implements IAnnotationTransformer {
    @Override
    public void transform(
            ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
        if (testMethod.getName().equals("add_data_provider_run_time_test")) {
            System.out.println("set data provider for " + testMethod.getName());
            annotation.setDataProviderClass(DataProviderFactory.class);
            annotation.setDataProvider("nameDp");

        } else if (testMethod.getName().equals("disable_run_time_test")) {
            System.out.println("Disable " + testMethod.getName());
            annotation.setEnabled(false);
        }
    }

}
