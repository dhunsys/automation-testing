package selenium;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;

import java.net.MalformedURLException;
import java.net.URL;

public class Drivers {
    private static final Logger logger = org.apache.log4j.Logger.getLogger(Drivers.class);
    public static WebDriver driver = null;

    public WebDriver getChromeDriver() {
       //linux
        // System.setProperty("webdriver.chrome.driver", "/home/ms/drivers/chromedriver");
        //windows
        System.setProperty("webdriver.chrome.driver", System.getProperty(("user.dir"))+"/drivers/chromedriver.exe");

        driver = new ChromeDriver();

        return driver;

    }

    public WebDriver getFirefoxDriver() {
        System.setProperty("webdriver.gecko.driver", System.getProperty(("user.dir"))+"/drivers/geckodriver.exe");
        FirefoxOptions options = new FirefoxOptions();
        options.setAcceptInsecureCerts(true);

        driver = new FirefoxDriver(options);

        return driver;

    }
    public WebDriver getChromeRemoteWebDriver(String hub) throws MalformedURLException {

        driver = new RemoteWebDriver(new URL(hub+":4444/wd/hub"), new ChromeOptions());

        return driver;
    }

    public WebDriver getFFRemoteWebDriver(String hub) throws MalformedURLException {

        driver = new RemoteWebDriver(new URL(hub+":4444/wd/hub"), new FirefoxOptions());

        return driver;
    }

    @AfterMethod
    public void afterMethod() {
        if (driver != null) {
            //driver.close();
            driver.quit();
        }
    }
}
