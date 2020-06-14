import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class BaseTest {

  WebDriver driver;
  JavascriptExecutor js = (JavascriptExecutor) driver;

  @BeforeMethod
  public void setUp(){
    System.setProperty("webdriver.chrome.driver", "C:\\Users\\Evgeney\\IdeaProjects\\lesson_2\\drivers\\chromedriver.exe");
    driver = new ChromeDriver();
    driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    driver.get("http://192.168.99.100/");
  }

  @AfterMethod
  public void tearDown() throws InterruptedException {
    Thread.sleep(5000);  // Let the user actually see something!
    driver.quit();
  }

}
