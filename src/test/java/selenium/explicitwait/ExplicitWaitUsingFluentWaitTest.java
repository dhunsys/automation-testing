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


    @Test(description = "page add a button at 5000ms . Test polls every 1000ms so in 5 polls element appears. Test pass")
    public void check_button_appears_in_5_seconds_pass_test() {

        WebDriver driver = getFirefoxDriver();

        driver.get("file:///" + System.getProperty("user.dir") + "/html/wait/explicit/explicit_wait_example5.html");
        Wait wait = new FluentWait(driver)
                .withTimeout(Duration.ofMillis(30000))//max time to wait
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
