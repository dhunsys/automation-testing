package selenium.input;

import org.assertj.core.util.Compatibility;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import selenium.Drivers;

import java.util.List;

public class InputTest extends Drivers {


    @Test(description = "sendKeys")
    public void sendKeys_test() {

        WebDriver driver = getChromeDriver();
        driver.get("file:///" + System.getProperty("user.dir") + "/html/input/input1.html");
        driver.manage().window().maximize();
        WebElement element = driver.findElement(By.id("q"));
        element.sendKeys("Selenium");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(element.getAttribute("value"), "Selenium");


    }

    @Test(description = "type using javascript test with arguments")
    public void type_javascript_test1() {

        WebDriver driver = getChromeDriver();
        driver.get("file:///" + System.getProperty("user.dir") + "/html/input/input1.html");
        driver.manage().window().maximize();
        WebElement element = driver.findElement(By.id("q"));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].value='Selenium';", element);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(element.getAttribute("value"), "Selenium");


    }

    @Test(description = "type javascript test without arguments by id")
    public void type_javascript_test2() {

        WebDriver driver = getChromeDriver();
        driver.get("file:///" + System.getProperty("user.dir") + "/html/input/input1.html");
        driver.manage().window().maximize();

        JavascriptExecutor js = (JavascriptExecutor) driver;

        WebElement element = (WebElement) js.executeScript("document.getElementById('q').value='Selenium'; return document.getElementById('q')");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(element.getAttribute("value"), "Selenium");


    }

    @Test(description = "type javascript test without arguments by name")
    public void type_javascript_test3() {

        WebDriver driver = getChromeDriver();
        driver.get("file:///" + System.getProperty("user.dir") + "/html/input/input2.html");
        driver.manage().window().maximize();

        JavascriptExecutor js = (JavascriptExecutor) driver;

        WebElement element = (WebElement) js.executeScript("document.getElementsByName('q')[0].value='Selenium'; return document.getElementsByName('q')[0]");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(element.getAttribute("value"), "Selenium");


    }

    @Test(description = "type using javascript test without arguments by name")
    public void type_using_javascript_test4() {

        WebDriver driver = getChromeDriver();
        driver.get("file:///" + System.getProperty("user.dir") + "/html/input/input2.html");
        driver.manage().window().maximize();

        JavascriptExecutor js = (JavascriptExecutor) driver;

        List<WebElement> elements = (List<WebElement>) js.executeScript("document.getElementsByName('q')[0].value='Selenium1';document.getElementsByName('q')[1].value='Selenium2'; document.getElementsByName('q')[2].value='Selenium3';return document.getElementsByName('q')");
        Assert.assertEquals(elements.get(0).getAttribute("value"), "Selenium1");
        Assert.assertEquals(elements.get(1).getAttribute("value"), "Selenium2");
        Assert.assertEquals(elements.get(2).getAttribute("value"), "Selenium3");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

}
