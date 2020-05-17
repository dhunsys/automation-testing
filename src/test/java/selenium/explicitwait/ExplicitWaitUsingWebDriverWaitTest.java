package selenium.explicitwait;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import selenium.Drivers;

public class ExplicitWaitUsingWebDriverWaitTest extends Drivers {

    @Test(description = "page opens alert after 5 seconds but explicit wait is set (2 seconds) so test fails")
    public void check_alert_appears_in_5_second_fail_test() {

        WebDriver driver = getFirefoxDriver();

        driver.get("file:///" + System.getProperty("user.dir") + "/html/wait/explicit/explicit_wait_example1.html");
        //on page open an alert appears so we can't do any action like max window until alert is dismissed. so comment below line
        //driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, 2);
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        String txt = alert.getText();
        alert.dismiss();
        Assert.assertEquals(txt, "Alert");

    }

    @Test(description = "page opens alert after 5 seconds but explicit wait is set (6 seconds) so test pass")
    public void check_alert_appears_in_5_second_pass_test() {

        WebDriver driver = getFirefoxDriver();

        driver.get("file:///" + System.getProperty("user.dir") + "/html/wait/explicit/explicit_wait_example1.html");
        //on page open an alert appears so we can't do any action like max wind until alert is dismissed. so comment below line
        //driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, 6);
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
        String txt = alert.getText();
        alert.dismiss();
        Assert.assertEquals(txt, "Alert");

    }

    @Test(description = "a button on page is disabled for 5000 ms and explicit wait is set to 4000 ms so test fail")
    public void click_button_if_disabled_fail_test() {

        WebDriver driver = getFirefoxDriver();

        driver.get("file:///" + System.getProperty("user.dir") + "/html/wait/explicit/explicit_wait_example2.html");
        //on page open an alert appears so we can't do any action like max wind until alert is dismissed. so comment below line
        //driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, 4);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("b1"))));

        element.click();

    }

    @Test(description = "a button on page is disabled for 5000 ms and explicit wait is set to 5000 ms so test pass")
    public void click_button_if_disabled_pass_test() {

        WebDriver driver = getFirefoxDriver();

        driver.get("file:///" + System.getProperty("user.dir") + "/html/wait/explicit/explicit_wait_example2.html");
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, 5);
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("b1"))));

        element.click();

    }

    @Test(description = "a checkbox is unchecked and checked after 5000 ms. So expecting state 'checked' before 5 seconds fail test")
    public void for_unselected_checkbox_except_checkbox_selected_fail_test() {

        WebDriver driver = getFirefoxDriver();

        driver.get("file:///" + System.getProperty("user.dir") + "/html/wait/explicit/explicit_wait_example3.html");
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, 4);
        wait.until(ExpectedConditions.elementSelectionStateToBe(driver.findElement(By.id("c1")), true));

    }

    @Test(description = "a checkbox is unchecked and checked after 5000 ms. So expecting state 'checked' in 5 seconds pass test")
    public void for_unselected_checkbox_except_checkbox_selected_pass_test() {

        WebDriver driver = getFirefoxDriver();

        driver.get("file:///" + System.getProperty("user.dir") + "/html/wait/explicit/explicit_wait_example3.html");
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.elementSelectionStateToBe(driver.findElement(By.id("c1")), true));

    }

    @Test(description = "except a title in 4 s but it appears after 5 seconds so test fails")
    public void title_is_fail_test() {

        WebDriver driver = getFirefoxDriver();
        driver.get("file:///" + System.getProperty("user.dir") + "/html/wait/explicit/explicit_wait_example4.html");
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, 4);
        wait.until(ExpectedConditions.titleIs("MSTitle"));

    }

    @Test(description = "except a title in 5 s and it appears in 5 seconds test pass")
    public void title_is_pass_test() {

        WebDriver driver = getFirefoxDriver();
        driver.get("file:///" + System.getProperty("user.dir") + "/html/wait/explicit/explicit_wait_example4.html");
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.titleIs("MSTitle"));

    }
}
