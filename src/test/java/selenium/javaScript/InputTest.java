package selenium.javaScript;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import selenium.Drivers;

import java.util.List;

public class InputTest extends Drivers {

    @Test(description = "type using java script with arguments")
    public void type_javascript_test1() throws InterruptedException {
        WebDriver driver = getChromeDriver();
        driver.get("file:///" + System.getProperty("user.dir") + "/html/input/input1.html");
        driver.manage().window().maximize();
        WebElement element = driver.findElement(By.id("q"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        //wait before enter text to see empty input field
        Thread.sleep(2000);
        js.executeScript("arguments[0].value='Selenium';", element);
        Thread.sleep(2000);
        Assert.assertEquals(element.getAttribute("value"), "Selenium");
    }

    @Test(description = "type using java script without arg by name")
    public void type_javascript_no_arg_by_name_test() throws InterruptedException {
        WebDriver driver = getChromeDriver();
        driver.get("file:///" + System.getProperty("user.dir") + "/html/input/input_by_name.html");
        driver.manage().window().maximize();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Thread.sleep(2000);
        WebElement w=(WebElement) js.executeScript("var we=document.getElementsByName('n')[0];we.value='Selenium'; return we;");
        Thread.sleep(2000);
        Assert.assertEquals(w.getAttribute("value"), "Selenium");
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

    @Test(description = "type using java script using array")
    public void type_using_javascript_test4() throws InterruptedException {
        WebDriver driver = getChromeDriver();
        driver.get("file:///" + System.getProperty("user.dir") + "/html/input/input2.html");
        driver.manage().window().maximize();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        List<WebElement> elements = (List<WebElement>) js.executeScript("" +
                "var elements=document.getElementsByName('n');" +
                "elements[0].value='Selenium1';elements[1].value='Selenium2'; " +
                "elements[2].value='Selenium3';return elements;");
        Thread.sleep(2000);
        Assert.assertEquals(elements.get(0).getAttribute("value"), "Selenium1");
        Assert.assertEquals(elements.get(1).getAttribute("value"), "Selenium2");
        Assert.assertEquals(elements.get(2).getAttribute("value"), "Selenium3");
        Thread.sleep(2000);
    }

    @Test(description = "type using java script using array with argument")
    public void type_using_javascript_test5() throws InterruptedException {
        WebDriver driver = getChromeDriver();
        driver.get("file:///" + System.getProperty("user.dir") + "/html/input/input2.html");
        driver.manage().window().maximize();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        List<WebElement> elements= driver.findElements(By.name("n"));
        Thread.sleep(2000);
        js.executeScript("arguments[0].value='Selenium1';arguments[1].value='Selenium2'; " +
                "arguments[2].value='Selenium3';",elements.get(0),elements.get(1),elements.get(2));
        Assert.assertEquals(elements.get(0).getAttribute("value"), "Selenium1");
        Assert.assertEquals(elements.get(1).getAttribute("value"), "Selenium2");
        Assert.assertEquals(elements.get(2).getAttribute("value"), "Selenium3");
        Thread.sleep(2000);
    }

}
