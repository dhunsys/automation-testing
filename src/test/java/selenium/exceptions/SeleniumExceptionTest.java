package selenium.exceptions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import selenium.Drivers;

public class SeleniumExceptionTest extends Drivers {

    @Test()
    public void element_not_visible_exception_test() {

        WebDriver driver = getFirefoxDriver();
        //Windows style for opening local file in browser
        //driver.get("file:///C:/"+System.getProperty("user.dir")+"/html/iframe/index.html");

        ////Linux style for opening local file in browser
        driver.get("file:///" + System.getProperty("user.dir") + "/html/selenium_exception/element_not_visible_exception.html");
        driver.manage().window().maximize();

        //Element is present-No Error
        WebElement element = driver.findElement(By.name("hidden"));
        //Error on next line: element not visible so cannot be interacted
        element.click();
    }

    @Test()
    public void no_such_element_exception_test() {

        WebDriver driver = getFirefoxDriver();
        //Windows style for opening local file in browser
        //driver.get("file:///C:/"+System.getProperty("user.dir")+"/html/iframe/index.html");

        ////Linux style for opening local file in browser
        driver.get("file:///" + System.getProperty("user.dir") + "/html/selenium_exception/no_such_element_exception.html");
        driver.manage().window().maximize();
        //No exception
        WebElement element = driver.findElement(By.name("nosuch"));
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        //Remove element
        javascriptExecutor.executeScript("document.getElementById('1').parentNode.removeChild(document.getElementById('1'));");
        //Error-Element is not present
        element = driver.findElement(By.name("nosuch"));

    }

    @Test()
    public void stale_element_exception_test() {

        WebDriver driver = getFirefoxDriver();
        //Windows style for opening local file in browser
        //driver.get("file:///C:/"+System.getProperty("user.dir")+"/html/iframe/index.html");

        ////Linux style for opening local file in browser
        driver.get("file:///" + System.getProperty("user.dir") + "/html/selenium_exception/stale_element_exception.html");
        driver.manage().window().maximize();

        WebElement element = driver.findElement(By.name("stale"));
        //No exception
        element.click();
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        //Remove element
        javascriptExecutor.executeScript("document.getElementById('1').parentNode.removeChild(document.getElementById('1'));");
        //Error-element reference is invalid as element removed. Any operation on such object throw stale element exception
        element.click();//stale element exception here
    }

    @Test()
    public void no_alert_present_exception_test() {

        WebDriver driver = getFirefoxDriver();
        //Windows style for opening local file in browser
        //driver.get("file:///C:/"+System.getProperty("user.dir")+"/html/iframe/index.html");

        ////Linux style for opening local file in browser
        driver.get("file:///" + System.getProperty("user.dir") + "/html/selenium_exception/no_alert_present_exception.html");
        //Exception as there is no alert. To pass add an alert in html and add a line 'driver.switchTo().alert().dismiss();' after below line
        driver.switchTo().alert();


    }
    }
