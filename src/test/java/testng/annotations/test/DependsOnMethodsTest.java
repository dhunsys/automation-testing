package testng.annotations.test;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DependsOnMethodsTest {
    @Test(alwaysRun = true,dependsOnMethods = {"test4","test5"})
    public void test6(){
        System.out.println("This is test6");
    }
    @Test
    public void test4(){
        Assert.assertEquals(1,1);
    }
    @Test
    public void test5(){
        Assert.assertEquals(1,2);
    }

}
