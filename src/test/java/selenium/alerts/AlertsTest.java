package selenium.alerts;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import selenium.Drivers;

public class AlertsTest extends Drivers {

    @Test()
    public void simple_alert_test() throws InterruptedException {
        WebDriver driver = getChromeDriver();
        driver.get("file:///" + System.getProperty("user.dir") + "/html/alerts/alerts.html");
        driver.manage().window().maximize();
        driver.findElement(By.id("simple")).click();
        Alert alert = driver.switchTo().alert();
        Thread.sleep(2000);
        alert.accept();
        String alertTxt = driver.findElement(By.id("response")).getText();
        Assert.assertEquals(alertTxt, "undefined");
        Thread.sleep(2000);
    }


    @Test()
    public void confirmation_alert_test() throws InterruptedException {

        WebDriver driver = getFirefoxDriver();
        driver.get("file:///" + System.getProperty("user.dir") + "/html/alerts/alerts.html");
        driver.manage().window().maximize();
        driver.findElement(By.id("confirmation")).click();
        Alert alert = driver.switchTo().alert();
        Thread.sleep(2000);
        alert.accept();//Click OK
        String alertTxt = driver.findElement(By.id("response")).getText();
        Assert.assertEquals(alertTxt, "true");
        Thread.sleep(10000);
        driver.findElement(By.id("confirmation")).click();//open alert again
        alert = driver.switchTo().alert();
        Thread.sleep(2000);
        alert.dismiss();//Press Cancel
        alertTxt = driver.findElement(By.id("response")).getText();
        Assert.assertEquals(alertTxt, "false");
        Thread.sleep(10000);

    }


    @Test()
    public void prompt_alert_test() throws InterruptedException {

        WebDriver driver = getFirefoxDriver();
        driver.get("file:///" + System.getProperty("user.dir") + "/html/alerts/alerts.html");
        driver.manage().window().maximize();
        driver.findElement(By.id("prompt")).click();
        Alert alert = driver.switchTo().alert();
        alert.sendKeys("Selenium");
        Thread.sleep(2000);
        alert.accept();
        String alertTxt = driver.findElement(By.id("response")).getText();
        Assert.assertEquals(alertTxt, "Selenium");

    }
}
