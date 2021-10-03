package testng.yaml.one_model;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.io.File;
import java.io.IOException;

public class OneModelYMLTest {
    @Test
    public void test1() {
        Login loginModel = loadYAMLData();
        Assert.assertEquals(loginModel.getUid() ,"dhunsi");
        Assert.assertEquals(loginModel.getPassword() ,"pass@123");
    }


        public Login loadYAMLData() {
            //Load YAML data into java Model:
            ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
            Login dao = null;
            try {
                dao = mapper.readValue(new File(System.getProperty("user.dir")+"\\src\\test\\java\\testng\\yaml\\login_model.yaml"), Login.class);
            } catch (IOException e) {
                e.printStackTrace();
            }

            return dao;
        }
}
