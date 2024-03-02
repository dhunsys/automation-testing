package rest_assured.util;

import com.google.gson.Gson;
import org.testng.annotations.Test;

import java.util.Map;

public class JsonToMap {

    public static Map getJsonMap(String args){
        String json = "{\n" +
                "    \"fields\": {\n" +
                "        \"project\": {\n" +
                "            \"key\": \"AP\"\n" +
                "        },\n" +
                "        \"summary\": \"something's wrong\",\n" +
                "\t\"description\": \"my restapi bug\"  ,      \n" +
                "\t\"issuetype\": {\n" +
                "            \"name\": \"Bug\"\n" +
                "        }\n" +
                "}\n" +
                "}";
        Gson gson = new Gson();
        Map map = gson.fromJson(json, Map.class);
       System.out.println(map);
       return map;
    }
}
