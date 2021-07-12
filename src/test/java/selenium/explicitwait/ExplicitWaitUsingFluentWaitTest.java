package selenium.explicitwait;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.Test;
import selenium.Drivers;

import java.time.Duration;
import java.util.function.Function;

public class ExplicitWaitUsingFluentWaitTest extends Drivers {

    @Test(description = "page create button in  15 seconds but explicit wait is set (10 seconds) so test fails")
    public void check_button_appears_in_10_second_fail_test() {
        WebDriver driver = getChromeDriver();
        driver.get("file:///" + System.getProperty("user.dir") + "/html/wait/explicit/explicit_wait_using_fluent_wait_example1.html");
        Wait wait = new FluentWait(driver)
                .withTimeout(Duration.ofMillis(10000))//max time to wait
                .pollingEvery(Duration.ofMillis(1000)) // to check element every 1000 ms
                .ignoring(NoSuchElementException.class);
        WebElement btn = (WebElement) wait.until(new Function<WebDriver, WebElement>() {
            int i = 0;
            @Override
            public WebElement apply(WebDriver webDriver) {
                System.out.println("POLLING NUMBER: " + i++);
                return driver.findElement(By.id("dynamicBtn"));
            }
        });
        Assert.assertEquals(btn.getText(), "CLICK ME");

    }
    @Test(description = "page add a button at 15000ms . Test polls every 1000ms so in 15 polls element appears. Test pass")
    public void check_button_appears_in_15_seconds_pass_test() {

        WebDriver driver = getChromeDriver();

        driver.get("file:///" + System.getProperty("user.dir") + "/html/wait/explicit/explicit_wait_using_fluent_wait_example1.html.html");
        Wait wait = new FluentWait(driver)
                .withTimeout(Duration.ofMillis(15000))//max time to wait
                .pollingEvery(Duration.ofMillis(1000)) // to check element every 1000ms
                .ignoring(NoSuchElementException.class);

        WebElement element = (WebElement) wait.until(new Function<WebDriver, WebElement>() {
            int i = 0;
            @Override
            public WebElement apply(WebDriver webDriver) {
                System.out.println("POLLING NUMBER: " + i++);// on 5th polling , element is found
                return driver.findElement(By.tagName("button"));
            }
        });
        Assert.assertEquals(element.getText(), "");


    }
}
