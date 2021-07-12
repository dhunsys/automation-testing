package selenium.javaScript;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import selenium.Drivers;

public class ButtonClickTest extends Drivers {

    @Test(description = "click a button using js with arguments")
    public void button_click_js_test() throws InterruptedException {
        WebDriver driver = getChromeDriver();
        driver.get("file:///" + System.getProperty("user.dir") + "/html/click/buttonClick.html");
        driver.manage().window().maximize();
        WebElement element = driver.findElement(By.id("q"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        //a little wait to see the change of button caption
        Thread.sleep(1000);
        js.executeScript("arguments[0].click();", element);
        Thread.sleep(1000);
        Assert.assertEquals(element.getText(),"CLICKED");
    }

    @Test(description = "click a button using js without arguments")
    public void button_click_js_no_args_test() throws InterruptedException {
        WebDriver driver = getChromeDriver();
        driver.get("file:///" + System.getProperty("user.dir") + "/html/click/buttonClick.html");
        driver.manage().window().maximize();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Thread.sleep(2000);
        //no argument
        js.executeScript("document.getElementById('q').click();");
        Thread.sleep(2000);
    }

    @Test(description = "click a button using js without arguments with return value")
    public void button_click_js_no_args_with_return_value_test() throws InterruptedException {
        WebDriver driver = getChromeDriver();
        driver.get("file:///" + System.getProperty("user.dir") + "/html/click/buttonClick.html");
        driver.manage().window().maximize();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Thread.sleep(2000);
        //store button reference in variable,perform click on variable,return the reference in test to perform assert
        WebElement element=(WebElement) js.executeScript("var we=document.getElementById('q');we.click(); return we");
        Assert.assertEquals(element.getText(),"CLICKED");
        Thread.sleep(2000);
    }
}
