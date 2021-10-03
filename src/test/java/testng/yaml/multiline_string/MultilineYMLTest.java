package testng.yaml.multiline_string;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import testng.yaml.one_model.Login;

import java.io.File;
import java.io.IOException;

public class MultilineYMLTest {
    @Test
    public void multiline_pipe_test() {
        MultilineModel multilineModel = loadYAMLData("multiline_pipeline.yaml");
        System.out.print(multilineModel.getMultiline());
    }
    @Test(description = "pass multiline string in YAML but test read it as single line using > in YAML")
    public void exclude_multiline_test() {
        MultilineModel multilineModel = loadYAMLData("exclude_multiline.yaml");
        System.out.print(multilineModel.getMultiline());
    }
    public MultilineModel loadYAMLData(String file) {
        //Load YAML data into java Model:
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        MultilineModel multilineModel = null;
        try {
            multilineModel = mapper.readValue(new File(System.getProperty("user.dir") + "\\src\\test\\java\\testng\\yaml\\multiline" +
                    "_string\\"+file), MultilineModel.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return multilineModel;
    }
}
