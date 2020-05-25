package selenium.keyboard;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import selenium.Drivers;

public class KeyboardTest extends Drivers {

    @Test()
    public void copy_paste_test() throws InterruptedException {

        WebDriver driver = getFirefoxDriver();
        //Windows style for opening local file in browser
        //driver.get("file:///C:/"+System.getProperty("user.dir")+"/html/iframe/index.html");

        ////Linux style for opening local file in browser
        driver.get("file:///" + System.getProperty("user.dir") + "/html/keyboard/copy.html");
        driver.manage().window().maximize();
        WebElement fname=driver.findElement(By.id("fname"));
        WebElement paste=driver.findElement(By.id("paste"));

        //Instantiate Actions class
        Actions actions = new Actions(driver);
        actions.sendKeys(fname,"Mr.Jones").perform();
       //select fname
        actions.keyDown(fname, Keys.CONTROL).sendKeys("a").release().perform();
        Thread.sleep(1000);
        //copy fname
        actions.keyDown(Keys.CONTROL).sendKeys("c").release().perform();

        Thread.sleep(1000);

        //Paste fname
        actions.keyDown(paste,Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).perform();
        Thread.sleep(1000);
        Assert.assertEquals(paste.getAttribute("value"),"Mr.Jones");
    }
}
