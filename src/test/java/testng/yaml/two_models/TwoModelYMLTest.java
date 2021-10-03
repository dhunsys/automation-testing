package testng.yaml.two_models;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class TwoModelYMLTest {
    @Test
    public void twoModelsInOneYAMLFileTest() {
        ModelsContainer modelsContainer = loadYAMLData();
        Assert.assertEquals(modelsContainer.getLoginModel().getUid() ,"dhunsi");
        Assert.assertEquals(modelsContainer.getLoginModel().getPassword() ,"pass@123");
        Assert.assertEquals(modelsContainer.getStudent().getName() ,"Student1");
        Assert.assertEquals(modelsContainer.getStudent().getRoll() ,1234);
    }


        public ModelsContainer loadYAMLData() {
            //Load YAML data into java Model:
            ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
            ModelsContainer modelsContainer = null;
            try {
                modelsContainer = mapper.readValue(new File(System.getProperty("user.dir")+"\\src\\test\\java\\testng\\yaml\\two_models.yaml"), ModelsContainer.class);
            } catch (IOException e) {
                e.printStackTrace();
            }

            return modelsContainer;
        }
}
