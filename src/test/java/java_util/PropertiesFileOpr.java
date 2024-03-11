package java_util;

import org.testng.annotations.Test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFileOpr {

    @Test
    public final void readPropertyFile() throws IOException {
        FileReader fileReader = new FileReader(System.getProperty("user.dir") + "\\src\\main\\resources\\log4j.properties");
        Properties properties = new Properties();
        properties.load(fileReader);
        System.out.println(properties.toString());

    }
}
