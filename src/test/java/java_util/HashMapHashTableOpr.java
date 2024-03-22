package java_util;

import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Hashtable;

public class HashMapHashTableOpr {

    /**
     * Allow only one null key. if more null key is added , the last one will be taken
     */
    @Test
    public final void HashMapAllowSingleNullKey(){
    HashMap<String,String> hashMap=new HashMap<>();
    hashMap.put(null,"ABC");
    hashMap.put(null,"XYZ");// overwrite 1st null key
    System.out.println(hashMap.toString());
}

    /**
     * HashMap allows any no of null value
     */
    @Test
    public final void HashMapAllowNullVal(){
        HashMap<String,String> hashMap=new HashMap<>();
        hashMap.put("K1",null);
        hashMap.put("K2",null);
        System.out.println(hashMap.toString());
    }

    /**
     * Allow no null key.
     */
    @Test
    public final void HashTableAllowNoNullKey(){
        Hashtable<String,String> hashtable=new Hashtable<>();
        hashtable.put(null,"ABC");//NullPointer Exception
        System.out.println(hashtable.toString());
    }

}
