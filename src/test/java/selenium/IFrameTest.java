package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;


public class IFrameTest extends Drivers {

    @Test()
    public void click_first_frame_button_fail_test() {

        WebDriver driver = getChromeDriver();
        driver.get("file:///" + System.getProperty("user.dir") + "/html/iframe/iframe_example1/index.html");
        driver.manage().window().maximize();
        WebElement element = driver.findElement(By.id("b1"));
        element.click();
    }

    @Test()
    public void click_first_frames_button_pass_test() {
        WebDriver driver = getChromeDriver();
        driver.get("file:///" + System.getProperty("user.dir") + "/html/iframe/iframe_example1/index.html");
        driver.manage().window().maximize();
        driver.switchTo().frame(0);// index starts from 0
        WebElement element = driver.findElement(By.id("b1"));
        element.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test()
    public void click_second_frames_button_pass_test() {
        WebDriver driver = getChromeDriver();
        driver.get("file:///" + System.getProperty("user.dir") + "/html/iframe/iframe_example1/index.html");
        driver.manage().window().maximize();
        driver.switchTo().frame("f1");// select frame by name
        WebElement element = driver.findElement(By.id("b1"));
        element.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test()
    public void click_first_frame_button_then_second_frame_button_fail_test() {
        WebDriver driver = getChromeDriver();
        driver.get("file:///" + System.getProperty("user.dir") + "/html/iframe/iframe_example1/index.html");
        driver.manage().window().maximize();
        driver.switchTo().frame(0);// select frame by index
        WebElement f1b1 = driver.findElement(By.id("b1"));
        f1b1.click();
        driver.switchTo().alert().dismiss();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.switchTo().frame(1);//exception here
        WebElement f2b1 = driver.findElement(By.id("b1"));
        f2b1.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test()
    public void click_first_frame_button_then_second_frame_button_using_default_content_pass_test() {
        WebDriver driver = getChromeDriver();
        driver.get("file:///" + System.getProperty("user.dir") + "/html/iframe/iframe_example1/index.html");
        driver.manage().window().maximize();
        driver.switchTo().frame(0);// select frame by name
        WebElement f1b1 = driver.findElement(By.id("b1"));
        f1b1.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.switchTo().alert().dismiss();
        //switch to main window
        driver.switchTo().defaultContent();
        driver.switchTo().frame(1);
        WebElement f2b1 = driver.findElement(By.id("b1"));
        f2b1.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.switchTo().alert().dismiss();
    }

    @Test()
    public void click_first_frame_button_then_second_frame_button_using_parent_frame_pass_test() {

        WebDriver driver = getFirefoxDriver();
        driver.get("file:///" + System.getProperty("user.dir") + "/html/iframe/iframe_example1/index.html");
        driver.manage().window().maximize();
        driver.switchTo().frame(0);// select frame by name
        WebElement f1b1 = driver.findElement(By.id("b1"));
        f1b1.click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.switchTo().alert().dismiss();
        //switch to main window
        driver.switchTo().parentFrame();
        driver.switchTo().frame(1);
        WebElement f2b1 = driver.findElement(By.id("b1"));
        f2b1.click();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.switchTo().alert().dismiss();
    }


    @Test(description = "A frame inside another frame is known as nested frame. When switching to nested frames, " +
            "there is no need to call defaultContent(). To move one level up in nesting call ‘parentFrame()’ method" +
            "Also order of traversal among frame is first,2nd,3rd.....and so on")
    public void traverse_and_find_text_in_h1_tag_in_nested_frame_pass_test() {

        WebDriver driver = getChromeDriver();
        driver.get("file:///" + System.getProperty("user.dir") + "/html/iframe/iframe_example3/index.html");
        Assert.assertEquals(driver.findElement(By.xpath("//h1")).getText(), "Index Page");
        driver.switchTo().frame(0); //we can use name
        Assert.assertEquals(driver.findElement(By.xpath("//h1")).getText(), "I am html-1");
        //Note-Index for nested frame will be 0. When moved to 1st frame that itself contains a single frame so index is 0
        driver.switchTo().frame(0);
        Assert.assertEquals(driver.findElement(By.xpath("//h1")).getText(), "I am html-2");
        //Note-Index for nested frame will be 0. When moved to 1st frame that itself contains a single frame so index is 0
        driver.switchTo().frame(0);
        Assert.assertEquals(driver.findElement(By.xpath("//h1")).getText(), "I am html-3");

    }
    @Test()
    public void traverse_in_reverse_order_pass_test() {

        WebDriver driver = getChromeDriver();
        driver.get("file:///" + System.getProperty("user.dir") + "/html/iframe/iframe_example3/index.html");
        driver.switchTo().frame(0); //we can use name
        driver.switchTo().frame(0);
        driver.switchTo().frame(0);
        //We r here at 3rd iframe
        Assert.assertEquals(driver.findElement(By.xpath("//h1")).getText(), "I am html-3");
        //switch to parent of current iframe
        driver.switchTo().parentFrame();
        Assert.assertEquals(driver.findElement(By.xpath("//h1")).getText(), "I am html-2");
        //switch to parent of current iframe
        driver.switchTo().parentFrame();
        Assert.assertEquals(driver.findElement(By.xpath("//h1")).getText(), "I am html-1");
    }
}