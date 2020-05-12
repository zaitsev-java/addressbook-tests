package addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {

    ChromeDriver driver;

    private GroupHelper groupHelper;

    public void init() {
        System.setProperty("webdriver.gecko.driver", "drivers/geckodriver");
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
//        driver = new FirefoxDriver();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://localhost:8080/addressbook/index.php");
        groupHelper = new GroupHelper(driver);
        login("admin", "secret");
    }

    public void login(String username, String password) {
        driver.findElement(By.name("user")).click();
        driver.findElement(By.name("user")).clear();
        driver.findElement(By.name("user")).sendKeys(username);
        driver.findElement(By.name("pass")).click();
        driver.findElement(By.name("pass")).clear();
        driver.findElement(By.name("pass")).sendKeys(password);
        driver.findElement(By.xpath("//body//input[3]")).click();
    }

    public void goToGroupPage() {
        driver.findElement(By.linkText("groups")).click();
    }

    public void stop() {
        driver.quit();
    }

    public GroupHelper getGroupHelper() {
        return groupHelper;
    }
}
