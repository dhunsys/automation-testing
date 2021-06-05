package selenium.implicitwait;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import selenium.Drivers;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class ImplicitWaitTest extends Drivers {

    @Test(description = "html page adds a button after 9000 ms. implicit wait is set to 1000 ms")
    public void find_button_before_it_appears_fail_test() {

        WebDriver driver = getChromeDriver();
        //set implicit wait 1000 ms
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(1000));
        driver.get("file:///" + System.getProperty("user.dir") + "/html/wait/implicit/implicit_example1.html");
        driver.manage().window().maximize();
        //fail as html will not have this button until 9000 ms
        int n=driver.findElements(By.xpath("//button[text()='CLICK ME']")).size();
        Assert.assertEquals(n,1);

    }
    @Test(description = "html page adds a button after 9000 ms. implicit wait is set to 9001 ms")
    public void find_button_before_it_appears_pass_test() {

        WebDriver driver = getChromeDriver();
        //set implicit wait 9001 ms > wait set in html
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(9001));
        driver.get("file:///" + System.getProperty("user.dir") + "/html/wait/implicit/implicit_example1.html");
        driver.manage().window().maximize();
         int n=driver.findElements(By.xpath("//button[text()='CLICK ME']")).size();
        Assert.assertEquals(n,1);

    }
}
