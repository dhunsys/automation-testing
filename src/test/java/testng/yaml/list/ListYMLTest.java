package testng.yaml.list;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import testng.yaml.multiline_string.MultilineModel;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class ListYMLTest {
    @Test
    public void list_test() {
        List<String> list = loadYAMLData("list.yaml");
        for(int i=0;i<list.size();i++)
            Assert.assertEquals(list.get(i),"item"+(i+1));
    }
    @Test(description = "")
    public void list_comma_separated_test() {
        List<String> list = loadYAMLData("list_comma_separated.yaml");
        for(int i=0;i<list.size();i++)
            Assert.assertEquals(list.get(i),"item"+(i+1));
    }

    @Test
    public void list_of_list_test() {
        List<List<String>> list = loadYAMLListOfListData("list_of_list.yaml");
        for(int i=0;i<list.size();i++)
            for(int j=0;j<list.get(i).size();j++) {
                Assert.assertEquals(list.get(i).get(j), "l"+(i+1)+"item" + (j + 1));
            }
    }
    @Test
    public void list_of_list_using_brackets_in_YAML_test() {
        List<List<String>> list = loadYAMLListOfListData("list_of_list_brackets.yaml");
        for(int i=0;i<list.size();i++)
            for(int j=0;j<list.get(i).size();j++) {
                Assert.assertEquals(list.get(i).get(j), "l"+(i+1)+"item" + (j + 1));
            }
    }
    public List<List<String>> loadYAMLListOfListData(String file) {
        //Load YAML data into java Model:
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        List<List<String>> list = null;
        try {
            list = mapper.readValue(new File(System.getProperty("user.dir") + "\\src\\test\\java\\testng\\yaml\\list\\"+file), List.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return list;
    }
    public List<String> loadYAMLData(String file) {
        //Load YAML data into java Model:
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        List<String> list = null;
        try {
            list = mapper.readValue(new File(System.getProperty("user.dir") + "\\src\\test\\java\\testng\\yaml\\list\\"+file), List.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return list;
    }
}
