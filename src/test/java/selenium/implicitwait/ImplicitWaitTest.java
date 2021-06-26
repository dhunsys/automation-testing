package selenium.implicitwait;

import org.apache.commons.lang3.time.DurationFormatUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import selenium.Drivers;

import java.time.Duration;
import java.util.Date;
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
        int n = driver.findElements(By.xpath("//button[text()='CLICK ME']")).size();
        Assert.assertEquals(n, 1);

    }

    @Test(description = "html page adds a button after 9000 ms. implicit wait is set to 9001 ms")
    public void find_button_before_it_appears_pass_test() {
        WebDriver driver = getChromeDriver();
        //set implicit wait 9001 ms > wait set in html
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(9001));
        driver.get("file:///" + System.getProperty("user.dir") + "/html/wait/implicit/implicit_example1.html");
        driver.manage().window().maximize();
        int n = driver.findElements(By.xpath("//button[text()='CLICK ME']")).size();
        Assert.assertEquals(n, 1);

    }
    @Test(description = "html page adds a button after 1000 ms. implicit wait is set to 9000 ms. " +
            "In minimum how much time script can find element? 1000 ms")
    public void driver_do_not_wait_anymore_if_element_found_earlier_pass_test() {
        Long startTime = 0L;
        Long endTime = 0l;
        WebDriver driver = getChromeDriver();
        //set implicit wait 9000 ms
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(9000));
        driver.get("file:///" + System.getProperty("user.dir") + "/html/wait/implicit/implicit_example2.html");
        driver.manage().window().maximize();
        startTime=(new Date()).getTime();
        int n = driver.findElements(By.xpath("//button[text()='CLICK ME']")).size();
        endTime=(new Date()).getTime();
        System.out.println("Time elapsed: "+calculateElapsedExecutionTime("HH:mm:ss.SS",startTime,endTime));
        Assert.assertEquals(n, 1);

    }
    public static String calculateElapsedExecutionTime(String format, Long startTime, Long endTime) {
        return DurationFormatUtils.formatDuration(endTime - startTime, format);
    }
}
