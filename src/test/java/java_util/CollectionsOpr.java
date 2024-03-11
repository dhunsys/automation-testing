package java_util;

import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.Collections;

public class CollectionsOpr {
    @Test
    public final void sortStringArrayCaseSensitive(){
        String s[]={"abc","ABC"};
        Collections.sort(Arrays.asList(s));
        for(String x:s)
        System.out.println(x);//prints  ABC abc
    }
    @Test
    public final void sortStringArrayCaseInSensitive(){
        String s[]={"abc","ABC"};
        Collections.sort(Arrays.asList(s),String.CASE_INSENSITIVE_ORDER);
        for(String x:s)
            System.out.println(x);//prints  abc ABC
    }
}
