package selenium.mouse;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import selenium.Drivers;

public class MouseTest extends Drivers {

    @Test()
    public void mouse_hover_fail_test() {

        WebDriver driver = getFirefoxDriver();
        //Windows style for opening local file in browser
        //driver.get("file:///C:/"+System.getProperty("user.dir")+"/html/iframe/index.html");

        ////Linux style for opening local file in browser
        driver.get("file:///" + System.getProperty("user.dir") + "/html/mouse/mousehover.html");
        driver.manage().window().maximize();
        driver.findElement(By.linkText("HTML")).click();
    }

    @Test()
    public void mouse_hover_pass_test() throws InterruptedException {

        WebDriver driver = getFirefoxDriver();
        //Windows style for opening local file in browser
        //driver.get("file:///C:/"+System.getProperty("user.dir")+"/html/iframe/index.html");

        ////Linux style for opening local file in browser
        driver.get("file:///" + System.getProperty("user.dir") + "/html/mouse/mousehover.html");
        driver.manage().window().maximize();

        Actions action = new Actions(driver);
        WebElement we = driver.findElement(By.linkText("Front End Design"));
        action.moveToElement(we).perform();
        Thread.sleep(2000);
        action.moveToElement(driver.findElement(By.linkText("HTML"))).click().perform();
        Thread.sleep(2000);
        driver.switchTo().alert().dismiss();

    }

    @Test()
    public void mouse_hover_multilevel_pass_test() throws InterruptedException {

        WebDriver driver = getFirefoxDriver();
        //Windows style for opening local file in browser
        //driver.get("file:///C:/"+System.getProperty("user.dir")+"/html/iframe/index.html");

        ////Linux style for opening local file in browser
        driver.get("file:///" + System.getProperty("user.dir") + "/html/mouse/mousehover.html");
        driver.manage().window().maximize();

        Actions action = new Actions(driver);
        WebElement we = driver.findElement(By.linkText("Front End Design"));
        action.moveToElement(we).perform();
        Thread.sleep(2000);
        action.moveToElement(driver.findElement(By.linkText("CSS"))).perform();
        Thread.sleep(2000);
        action.moveToElement(driver.findElement(By.linkText("Grids"))).click().perform();
        Thread.sleep(2000);
        driver.switchTo().alert().dismiss();

    }
}
