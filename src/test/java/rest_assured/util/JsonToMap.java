package rest_assured.util;

import com.google.gson.Gson;
import org.testng.annotations.Test;

import java.util.Map;

public class JsonToMap {

    public static Map getJsonMap(String json){
        Gson gson = new Gson();
        Map map = gson.fromJson(json, Map.class);
       System.out.println(map);
       return map;
    }
}
