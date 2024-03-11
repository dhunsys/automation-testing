package java_util;

import org.testng.Assert;
import org.testng.annotations.Test;

public class StringOpr {
    @Test
    public final void verifyTwoStringEqualPass(){
        String s="Hello";
        String y="Hello";
        Assert.assertTrue(s==y);
    }
    @Test
    public final void verifyTwoStringEqualFail(){
        String s="Hello";
        String y=new String("Hello");
        Assert.assertTrue(s==y);
    }
    @Test
    public final void verifyTwoStringEqualFail1(){
        String s=new String("Hello");
        String y=new String("Hello");
        Assert.assertTrue(s==y);
    }
    @Test
    public final void verifyTwoStringEqualPass1(){
        String s=new String("Hello");
        String y=new String("Hello");
        Assert.assertTrue(s.equals(y));
    }
    @Test
    public final void verifyTwoStringEqualPass2(){
        String s="Hello";
        String y=new String("Hello");
        Assert.assertTrue(s.equals(y));
    }
    @Test
    public final void verifyTwoStringEqualPass3(){
        String s="Hello";
        String y="Hello";
        Assert.assertTrue(s.equals(y));
    }
}
