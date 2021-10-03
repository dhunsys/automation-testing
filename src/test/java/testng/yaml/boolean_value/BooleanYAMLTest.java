package testng.yaml.boolean_value;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.util.Map;

public class BooleanYAMLTest {
    @Test
    public void mapYAMLTest() {
        BooleanModel booleanModel=loadYAMLData("boolean.yaml");
        Assert.assertEquals(booleanModel.isMarried(),true);
        Assert.assertEquals(booleanModel.isNri(),false);
    }

    public BooleanModel loadYAMLData(String file) {
        //Load YAML data into java Model:
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        BooleanModel booleanModel = null;
        try {
            booleanModel = mapper.readValue(new File(System.getProperty("user.dir")+"\\src\\test\\java\\testng\\yaml\\boolean_value\\"+file), BooleanModel.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return booleanModel;
    }
}
