package java_util;

import org.testng.annotations.Test;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Iterator;
import java.util.ListIterator;

public class IteratorOpr {

    /**
     * iterator moves only forward
     */
    @Test
    public final void createIterator(){
        String[]country={"India","Canada","UK","FR"};
        Iterator<String> itr= Arrays.asList(country).iterator();
        while (itr.hasNext()){
            System.out.println(itr.next());
        }
    }

    /**
     * Traverse in both dir.
     * but first go forward to reach last then traverse backward.
     */
    @Test
    public final void createListIterator(){
        String[]country={"India","Canada","UK","FR"};
        ListIterator<String> itr= Arrays.asList(country).listIterator();
        while (itr.hasNext()){
            System.out.println(itr.next());
        }
        while (itr.hasPrevious()){
            System.out.println(itr.previous());
        }
    }

}
