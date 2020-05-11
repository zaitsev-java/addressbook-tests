package addressbook;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class GroupCreationTests {

    WebDriver driver;

    @BeforeMethod
    public void setUp() throws Exception {
        System.setProperty("webdriver.gecko.driver", "drivers/geckodriver");
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
//        driver = new FirefoxDriver();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("http://localhost:8080/addressbook/index.php");

        driver.findElement(By.name("user")).click();
        driver.findElement(By.name("user")).clear();
        driver.findElement(By.name("user")).sendKeys("admin");

        driver.findElement(By.name("pass")).click();
        driver.findElement(By.name("pass")).clear();
        driver.findElement(By.name("pass")).sendKeys("secret");

        driver.findElement(By.xpath("//body//input[3]")).click();
    }

    @Test
    public void testGroupCreation() {


        driver.findElement(By.linkText("groups")).click();

        driver.findElement(By.name("new")).click();

        driver.findElement(By.name("group_name")).click();
        driver.findElement(By.name("group_name")).clear();
        driver.findElement(By.name("group_name")).sendKeys("test1");

        driver.findElement(By.name("group_header")).click();
        driver.findElement(By.name("group_header")).clear();
        driver.findElement(By.name("group_header")).sendKeys("test2");

        driver.findElement(By.name("group_footer")).click();
        driver.findElement(By.name("group_footer")).clear();
        driver.findElement(By.name("group_footer")).sendKeys("test3");

        driver.findElement(By.name("submit")).click();

        driver.findElement(By.linkText("group page")).click();

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }


}
