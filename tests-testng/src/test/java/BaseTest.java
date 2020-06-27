import org.openqa.selenium.By;
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
    login();
  }

  @AfterMethod
  public void tearDown() throws InterruptedException {
    Thread.sleep(5000);  // Let the user actually see something!
    driver.quit();
  }

  private void login() {
    driver.findElement(By.id("tl_login")).sendKeys("user");
    driver.findElement(By.id("tl_password")).sendKeys("bitnami");
    driver.findElement(By.id("tl_login_button")).click();
  }

  protected void testSuiteClick() {
    //клик по тест съюту
    driver.switchTo().defaultContent();
    driver.switchTo().frame(1);
    driver.switchTo().frame(0);
    driver.findElement(By.xpath("//span[contains(text(),'test_suite')]")).click();
  }

  public void gearTestSuiteClick() throws InterruptedException {
    //клик по шестеренке тест съюта
    driver.switchTo().defaultContent();
    driver.switchTo().frame(1);
    driver.switchTo().frame(1);
    Thread.sleep(1000);
    driver.findElement(By.xpath
            ("//div[@class='workBack']/img[2]")).click();
  }

  protected void deleteTestSuiteWithAllChildren() {
    driver.switchTo().defaultContent();
    driver.switchTo().frame(1);
    driver.switchTo().frame(1);
    driver.findElement(By.id("delete_testsuite")).click();
    driver.findElement(By.name("delete_testsuite")).click();
  }
}
