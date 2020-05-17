package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import selenium.Drivers;

public class XPathTest extends Drivers {


    @Test()
    public void absolutePath_1st_employee_Fail_Test() throws InterruptedException {
        WebDriver driver = getFirefoxDriver();
        //Windows style for opening local file in browser
        //driver.get("file:///C:/"+System.getProperty("user.dir")+"/html/xpath/xpath.xml");

        ////Linux style for opening local file in browser
        driver.get("file:///"+System.getProperty("user.dir")+"/html/xpath/xpath.xml");
        driver.manage().window().maximize();
        Thread.sleep(2000);
        //As tag starts with single slash that means root but employee is not root so test fails
        WebElement singleSlash=driver.findElement(By.xpath("/employee"));
        Assert.assertEquals(singleSlash.getAttribute("id"),"1");


    }
    @Test()
    public void absolutePath_1st_employee_Pass_Test() throws InterruptedException {
        WebDriver driver = getFirefoxDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.get("file:///"+System.getProperty("user.dir")+"/html/xpath/xpath.xml");
        driver.manage().window().maximize();
        Thread.sleep(2000);
        //Always give firs element if same tag appears more than once on same level
        WebElement singleSlash=driver.findElement(By.xpath("/empinfo/employee"));
        Assert.assertEquals(singleSlash.getAttribute("id"),"1");


    }
    @Test()
    public void absolutePath_2nd_employee_Pass_Test() throws InterruptedException {
        WebDriver driver = getFirefoxDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.get("file:///"+System.getProperty("user.dir")+"/html/xpath/xpath.xml");
        driver.manage().window().maximize();
        Thread.sleep(2000);
        //Always give firs if same tag appears more than once on ame level. To select specific provide more info of that tag
        WebElement singleSlash=driver.findElement(By.xpath("/empinfo/employee[@id='2']"));
        Assert.assertEquals(singleSlash.getAttribute("id"),"2");


    }
    @Test()
    public void relativePath_1st_employee_Pass_Test() throws InterruptedException {
        WebDriver driver = getFirefoxDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.get("file:///"+System.getProperty("user.dir")+"/html/xpath/xpath.xml");
        driver.manage().window().maximize();
        Thread.sleep(2000);
        //Give first element on entire page
        WebElement singleSlash=driver.findElement(By.xpath("//employee"));
        Assert.assertEquals(singleSlash.getAttribute("id"),"1");


    }
    @Test()
    public void relativePath_2nd_employee_Pass_Test() throws InterruptedException {
        WebDriver driver = getFirefoxDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.get("file:///"+System.getProperty("user.dir")+"/html/xpath/xpath.xml");
        driver.manage().window().maximize();
        Thread.sleep(2000);
        //Give first element on entire page. For specific one provide more details
        WebElement singleSlash=driver.findElement(By.xpath("//employee[@id='2']"));
        Assert.assertEquals(singleSlash.getAttribute("id"),"2");


    }

    @Test()
    public void mix_path1_Test() throws InterruptedException {
        WebDriver driver = getFirefoxDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.get("file:///"+System.getProperty("user.dir")+"/html/xpath/xpath.xml");
        driver.manage().window().maximize();
        Thread.sleep(2000);
        //Give first name element
        WebElement singleSlash=driver.findElement(By.xpath("/empinfo//name"));
        Assert.assertEquals(singleSlash.getText(),"Jhon");


    }
    @Test()
    public void mix_path2_Pass_Test() throws InterruptedException {
        WebDriver driver = getFirefoxDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.get("file:///"+System.getProperty("user.dir")+"/html/xpath/xpath.xml");
        driver.manage().window().maximize();
        Thread.sleep(2000);
        //give first 'employee' designation
        WebElement singleSlash=driver.findElement(By.xpath("//employee/designation"));
        Assert.assertEquals(singleSlash.getText(),"Senior Consultant");


    }
    @Test()
    public void mix_path3_Pass_Test() throws InterruptedException {
        WebDriver driver = getFirefoxDriver();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.get("file:///"+System.getProperty("user.dir")+"/html/xpath/xpath.xml");
        driver.manage().window().maximize();
        Thread.sleep(2000);
        //By default give first employee's designation but additional info looks for 2nd employee
        WebElement singleSlash=driver.findElement(By.xpath("//employee/designation[@discipline='QA']"));
        Assert.assertEquals(singleSlash.getText(),"QA Engineer");


    }

    
}
