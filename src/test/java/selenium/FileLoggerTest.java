package selenium;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class FileLoggerTest extends Drivers {
    Logger log = Logger.getLogger("FileLoggerTest");
    @Test()
    public void root_log_test() {

        WebDriver driver = getFirefoxDriver();
        //Windows style for opening local file in browser
        //driver.get("file:///C:/"+System.getProperty("user.dir")+"/html/iframe/index.html");

        ////Linux style for opening local file in browser
        log.debug("file is the identifier. it is used to give file name in which logs will be saved");

    }
}