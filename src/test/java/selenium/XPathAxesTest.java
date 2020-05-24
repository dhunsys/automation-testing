package selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Set;

public class XPathAxesTest extends Drivers {


    /*
    Selects everything in the document after the closing tag of the current node
    */
    @Test()
    public void following_axes_Pass_Test() throws InterruptedException {
        WebDriver driver = getFirefoxDriver();
        driver.get("file:///" + System.getProperty("user.dir") + "/html/xpath/xpath_axes.xml");
        driver.manage().window().maximize();
        Thread.sleep(2000);
        //After root bookstore tag there are 2 book tags
        int n = driver.findElements(By.xpath("/bookstore//following::book")).size();// use index to find specific elem like //*[@type='text']//following::input[1]
        Assert.assertEquals(n, 2);
        //After bookstore/book there are 1 book tag
        n = driver.findElements(By.xpath("/bookstore/book//following::book")).size();
        Assert.assertEquals(n, 1);

    }

    /*
    Selects all ancestors (parent, grandparent, etc.) of the current node
    */
    @Test()
    public void ancestor_Pass_Test() throws InterruptedException {
        WebDriver driver = getFirefoxDriver();
        driver.get("file:///" + System.getProperty("user.dir") + "/html/xpath/xpath_axes.xml");
        driver.manage().window().maximize();
        Thread.sleep(2000);
        //Selects all book ancestors of the current node
        int n = driver.findElements(By.xpath("//price[text()='39.95']//ancestor::book")).size();
        Assert.assertEquals(n, 1);

    }

    /*
    Selects all ancestors (parent, grandparent, etc.) of the current node and the current node itself
    */
    @Test()
    public void ancestor_or_self_Pass_Test() throws InterruptedException {
        WebDriver driver = getFirefoxDriver();
        driver.get("file:///" + System.getProperty("user.dir") + "/html/xpath/xpath_axes.xml");
        driver.manage().window().maximize();
        Thread.sleep(2000);
        //Selects all div ancestors of the current node - and the current as well if it is a div node
        int n = driver.findElements(By.xpath("//div[@class='divclass']//ancestor-or-self::div")).size();
        Assert.assertEquals(n, 2);

    }

    /*
 Selects all children of the current node
 */
    @Test()
    public void all_child_Pass_Test() throws InterruptedException {
        WebDriver driver = getFirefoxDriver();
        driver.get("file:///" + System.getProperty("user.dir") + "/html/xpath/xpath_axes.xml");
        driver.manage().window().maximize();
        Thread.sleep(2000);
        //Selects all child of bookstore (i.e. 2 books and one div)
        int n = driver.findElements(By.xpath("//bookstore/child::*")).size();
        Assert.assertEquals(n, 3);

    }

    /*
   Selects all book nodes that are children of the current node
   */
    @Test()
    public void child_book_Pass_Test() throws InterruptedException {
        WebDriver driver = getFirefoxDriver();
        driver.get("file:///" + System.getProperty("user.dir") + "/html/xpath/xpath_axes.xml");
        driver.manage().window().maximize();
        Thread.sleep(2000);
        //Selects all div ancestors of the current node - and the current as well if it is a div node
        int n = driver.findElements(By.xpath("/bookstore//child::book")).size();
        Assert.assertEquals(n, 2);

    }

    /*
Selects parent of the current node
*/
    @Test()
    public void find_parent_Pass_Test() throws InterruptedException {
        WebDriver driver = getFirefoxDriver();
        driver.get("file:///" + System.getProperty("user.dir") + "/html/xpath/xpath_axes.xml");
        driver.manage().window().maximize();
        Thread.sleep(2000);
        //Selects parent of title (i.e. book)
        int n = driver.findElements(By.xpath("/bookstore/book/title[@lang='en']/parent::*")).size();
        Assert.assertEquals(n, 1);

    }

    /*
   Selects all book descendants of the current node
   */
    @Test()
    public void descendant_book_Pass_Test() throws InterruptedException {
        WebDriver driver = getFirefoxDriver();
        driver.get("file:///" + System.getProperty("user.dir") + "/html/xpath/xpath_axes.xml");
        driver.manage().window().maximize();
        Thread.sleep(2000);
        //Selects all book node that are child of current(bookstore) node
        int n = driver.findElements(By.xpath("/bookstore/descendant::book")).size();
        Assert.assertEquals(n, 2);

    }

    /*
  Select the following siblings of the context node. Siblings are at the same level of the current node as shown in the below screen. It will find the element after the current node.
  */
    @Test()
    public void all_following_siblings_Pass_Test() throws InterruptedException {
        WebDriver driver = getFirefoxDriver();
        driver.get("file:///" + System.getProperty("user.dir") + "/html/xpath/xpath_axes.xml");
        driver.manage().window().maximize();
        Thread.sleep(2000);
        //Selects all siblings of book node (siblings are book,dive)
        int n = driver.findElements(By.xpath("//bookstore/book/following-sibling::*")).size();
        Assert.assertEquals(n, 2);

    }

    /*
Select the following siblings of the context node. Siblings are at the same level of the current node as shown in the below screen. It will find the element after the current node.
*/
    @Test()
    public void following_siblings_specific_Pass_Test() throws InterruptedException {
        WebDriver driver = getFirefoxDriver();
        driver.get("file:///" + System.getProperty("user.dir") + "/html/xpath/xpath_axes.xml");
        driver.manage().window().maximize();
        Thread.sleep(2000);
        //Selects all 'div' siblings of book node (one div)
        int n = driver.findElements(By.xpath("//bookstore/book/following-sibling::div")).size();
        Assert.assertEquals(n, 1);

    }


}