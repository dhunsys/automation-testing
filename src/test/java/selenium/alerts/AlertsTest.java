package selenium.alerts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import selenium.Drivers;

public class AlertsTest extends Drivers {

    @Test()
    public void simple_alert_test() throws InterruptedException {

        WebDriver driver = getFirefoxDriver();
        //Windows style for opening local file in browser
        //driver.get("file:///C:/"+System.getProperty("user.dir")+"/html/iframe/index.html");

        ////Linux style for opening local file in browser
        driver.get("file:///" + System.getProperty("user.dir") + "/html/alerts/alerts.html");
        driver.manage().window().maximize();
        driver.findElement(By.id("simple")).click();
        String alertTxt = driver.switchTo().alert().getText();
        Thread.sleep(2000);
        driver.switchTo().alert().dismiss();
        Assert.assertEquals(alertTxt, "Simple alert");

    }

    @Test()
    public void confirmation_alert_test() throws InterruptedException {

        WebDriver driver = getFirefoxDriver();
        //Windows style for opening local file in browser
        //driver.get("file:///C:/"+System.getProperty("user.dir")+"/html/iframe/index.html");

        ////Linux style for opening local file in browser
        driver.get("file:///" + System.getProperty("user.dir") + "/html/alerts/alerts.html");
        driver.manage().window().maximize();
        driver.findElement(By.id("confirmation")).click();
        String alertTxt = driver.switchTo().alert().getText();
        Thread.sleep(2000);
        driver.switchTo().alert().accept();
        Assert.assertEquals(alertTxt, "Confirmation alert");

    }

    @Test()
    public void prompt_alert_test() throws InterruptedException {

        WebDriver driver = getFirefoxDriver();
        //Windows style for opening local file in browser
        //driver.get("file:///C:/"+System.getProperty("user.dir")+"/html/iframe/index.html");

        ////Linux style for opening local file in browser
        driver.get("file:///" + System.getProperty("user.dir") + "/html/alerts/alerts.html");
        driver.manage().window().maximize();
        driver.findElement(By.id("prompt")).click();
        String alertTxt = driver.switchTo().alert().getText();
        driver.switchTo().alert().sendKeys("MShahabuddin");
        Thread.sleep(2000);
        driver.switchTo().alert().accept();
        Assert.assertEquals(alertTxt, "Enter your name");

    }
}
