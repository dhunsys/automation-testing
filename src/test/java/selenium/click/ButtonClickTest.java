package selenium.click;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.Test;
import selenium.Drivers;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Function;

public class ButtonClickTest extends Drivers {
    @Test(description = "click a button")
    public void button_click_test1() throws InterruptedException {
        WebDriver driver = getChromeDriver();
        driver.get("https://testng-selenium.blogspot.com/");
        driver.manage().window().maximize();
        int i=0;
       while(i<1000){
           i++;
           driver.navigate().refresh();
           Thread.sleep(1000);
       }
    }

    @Test(description = "click a button")
    public void button_click_test() {
        WebDriver driver = getChromeDriver();
        driver.get("file:///" + System.getProperty("user.dir") + "/html/click/buttonClick.html");
        driver.manage().window().maximize();
        WebElement element = driver.findElement(By.id("q"));
        element.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(element.getText(),"CLICKED");
    }

    @Test(description = "click a button using js with arguments")
    public void button_click_js_test() {

        WebDriver driver = getChromeDriver();
        driver.get("file:///" + System.getProperty("user.dir") + "/html/click/buttonClick.html");
        driver.manage().window().maximize();
        WebElement element = driver.findElement(By.id("q"));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", element);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(element.getText(),"CLICKED");


    }

    @Test(description = "click a button using js without arguments")
    public void button_click_js_no_args_test() {

        WebDriver driver = getChromeDriver();
        driver.get("file:///" + System.getProperty("user.dir") + "/html/click/buttonClick.html");
        driver.manage().window().maximize();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        //no argument
        WebElement element=(WebElement) js.executeScript("document.getElementById('q').click();return document.getElementById('q') ");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(element.getText(),"CLICKED");


    }



}
