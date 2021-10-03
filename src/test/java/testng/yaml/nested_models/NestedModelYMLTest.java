package testng.yaml.nested_models;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class NestedModelYMLTest {
    @Test
    public void nestedModelsInOneYAMLFileTest() {
        Employee employee = loadYAMLData();
        Assert.assertEquals(employee.getName() ,"Dhunsi");
        Assert.assertEquals(employee.getNo() ,123);
        Assert.assertEquals(employee.getAddress().getStreet() ,"Dhunsi Ramnagar");
        Assert.assertEquals(employee.getAddress().getDistrict() ,"DGB");
        Assert.assertEquals(employee.getAddress().getCountry() ,"India");
        Assert.assertEquals(employee.getAddress().getPin() ,865234);
    }


        public Employee loadYAMLData() {
            //Load YAML data into java Model:
            ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
            Employee employee = null;
            try {
                employee = mapper.readValue(new File(System.getProperty("user.dir")+"\\src\\test\\java\\testng\\yaml\\nested_models\\nested_models.yaml"), Employee.class);
            } catch (IOException e) {
                e.printStackTrace();
            }

            return employee;
        }
}
