package selenium.switchwindow;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import selenium.Drivers;

public class SwitchWindowTest extends Drivers {

    @Test
    public void switchWindow1() {
        switchDesiredWindow("Window-1-title");
    }

    @Test
    public void switchWindow2() {
        switchDesiredWindow("Window-2-title");
    }

    @Test
    public void switchWindow3() {
        switchDesiredWindow("Window-3-title");
    }

    public void switchDesiredWindow(String winTitle) {


        WebDriver driver = getFirefoxDriver();
        driver.manage().window().maximize();
        driver.get("file:///" + System.getProperty("user.dir") + "/html/switch_window/index.html");

        WebElement element = driver.findElement(By.id("index"));


        String parent = driver.getWindowHandle();
        element.click();
        for (String child : driver.getWindowHandles()) {
            if (!parent.equalsIgnoreCase(child)) {
                WebDriver dr = driver.switchTo().window(child);
                if (winTitle.equalsIgnoreCase(dr.getTitle())) {

                    driver.findElement(By.id("changeTitle")).click();
                    try {
                        Thread.sleep(9000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    break;
                }
            }
        }
    }

}

