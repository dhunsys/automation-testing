package testng.yaml.hash_map;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class HashMapYAMLTest {
    @Test
    public void mapYAMLTest() {
        Map<String,Object> map = loadYAMLData("hashmap_model.yaml");
        Assert.assertEquals(map.get("key1").toString() ,"value1");
        Assert.assertEquals(map.get("key2").toString() ,"value2");
    }
    @Test
    public void mapYAMLCommaSeparatedTest() {
        Map<String,Object> map = loadYAMLData("hashmap_model_comma_separated.yaml");
        Assert.assertEquals(map.get("key1").toString() ,"value1");
        Assert.assertEquals(map.get("key2").toString() ,"value2");
    }
    @Test
    public void mapOfListOfMapYAMLTest() {
        Map<String, List<Map<String,String>>> map = loadMapOfListOfMapYAMLData("map_of_list_of_map.yaml");

        for (String key:map.keySet()){
          for(int i=0;i<map.get(key).size();i++)  {
              System.out.println("list "+i+" of map "+key+"\n"+map.get(key).get(i).toString());
          }
        }
     }
        public Map<String,Object> loadYAMLData(String file) {
            //Load YAML data into java Model:
            ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
            Map<String,Object> map = null;
            try {
                map = mapper.readValue(new File(System.getProperty("user.dir")+"\\src\\test\\java\\testng\\yaml\\hash_map\\"+file), Map.class);
            } catch (IOException e) {
                e.printStackTrace();
            }

            return map;
        }
    public Map<String, List<Map<String,String>>> loadMapOfListOfMapYAMLData(String file) {
        //Load YAML data into java Model:
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        Map<String, List<Map<String,String>>> map = null;
        try {
            map = mapper.readValue(new File(System.getProperty("user.dir")+"\\src\\test\\java\\testng\\yaml\\hash_map\\"+file), ConcurrentHashMap.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return map;
    }
}
