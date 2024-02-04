package selenium.exceptions;

import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import selenium.Drivers;

public class SeleniumExceptionTest extends Drivers {

    @Test()
    public void element_not_interactable_exception_test() throws InterruptedException {
        WebDriver driver = getChromeDriver();
        driver.get("file:///" + System.getProperty("user.dir") + "/html/selenium_exception/element_not_interactable_exception.html");
        driver.manage().window().maximize();
        //Element is present-No Error
        WebElement element = driver.findElement(By.name("hidden"));
        Thread.sleep(1000);
        //Error on next line: element not visible so cannot be interacted
        element.click();
    }

    @Test()
    public void no_such_element_exception_test() {
        WebDriver driver = getChromeDriver();
        driver.get("file:///" + System.getProperty("user.dir") + "/html/selenium_exception/no_such_element_exception.html");
        driver.manage().window().maximize();
        //No exception
        WebElement element = driver.findElement(By.name("nse"));
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Assert.assertEquals(element.getAttribute("value"), "NoSuchEE");
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        //Remove above element
        javascriptExecutor.executeScript("document.getElementById('1').parentNode.removeChild(document.getElementById('1'));");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //Error-Element is not present
        element = driver.findElement(By.name("nse"));
        Assert.assertEquals(element.getAttribute("value"), "NoSuchEE");
    }


    @Test()
    public void stale_element_reference_exception_removing_web_element_test() {
        WebDriver driver = getChromeDriver();
        driver.get("file:///" + System.getProperty("user.dir") + "/html/selenium_exception/stale_element_exception.html");
        driver.manage().window().maximize();
        WebElement element = driver.findElement(By.name("stale"));
        //No exception
        element.click();
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        //Remove element
        javascriptExecutor.executeScript("document.getElementById('1').parentNode.removeChild(document.getElementById('1'));");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //Error-element reference is invalid as element removed. Any operation on such object throw stale element ref exception
        element.click();//stale element ref exception here
    }


    @Test()
    public void stale_element_reference_exception_by_refresh_test() {
        WebDriver driver = getChromeDriver();
        driver.get("file:///" + System.getProperty("user.dir") + "/html/selenium_exception/stale_element_exception.html");
        driver.manage().window().maximize();
        WebElement element = driver.findElement(By.name("stale"));
        //No exception
        element.click();
        driver.navigate().refresh();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //Error-element reference is invalid as element removed. Any operation on such object throw stale element exception
        element.click();//stale element exception here
    }


    @Test()
    public void stale_element_reference_exception_by_navigating_test() {
        WebDriver driver = getChromeDriver();
        driver.get("file:///" + System.getProperty("user.dir") + "/html/selenium_exception/stale_element_exception.html");
        driver.manage().window().maximize();
        WebElement element = driver.findElement(By.name("stale"));
        //No exception
        element.click();
        driver.navigate().to("file:///" + System.getProperty("user.dir") + "/html/selenium_exception/new_page.html");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.navigate().back();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //Error-element reference is invalid as soon as moved to new page. Coming back to original need finding the element again
        element.click();//stale element exception here
    }


    @Test()
    public void webdriver_exception_test() {
        WebDriver driver = getChromeDriver();
        driver.get("file:///" + System.getProperty("user.dir") + "/html/selenium_exception/new_page.html");
        driver.manage().window().maximize();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//close browser manually

    }


    @Test()
    public void session_not_found_exception_test() {
        WebDriver driver = getChromeDriver();
        driver.get("file:///" + System.getProperty("user.dir") + "/html/selenium_exception/new_page.html");
        driver.manage().window().maximize();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.getTitle();
        driver.quit();
        driver.getTitle();
    }

    @Test()
    public void no_alert_present_exception_test() {
        WebDriver driver = getChromeDriver();
        driver.get("file:///" + System.getProperty("user.dir") + "/html/selenium_exception/no_alert_present_exception.html");
        driver.switchTo().alert();
    }
    /**
     * Element is behind an element
     * @throws InterruptedException
     */
    @Test()
    public void element_intercepted_exception_test() throws InterruptedException {
        WebDriver driver = getChromeDriver();
        driver.get("https://www.google.com");
        driver.manage().window().maximize();
        driver.findElement(By.name("q")).click();
        Thread.sleep(1000);
        WebElement element=driver.findElement(By.xpath("//*[@id='SIvCob']/a[1]"));
        Thread.sleep(1000);
        driver.findElement(By.name("q")).sendKeys(Keys.ESCAPE);
        Thread.sleep(1000);
        element.click();
        Thread.sleep(1000);
    }
}
