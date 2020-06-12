import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class CreatingTestSuiteTest {
  
  @Test
  public void creatingTestSuite() throws InterruptedException {
    System.setProperty("webdriver.chrome.driver", "C:\\Users\\Evgeney\\IdeaProjects\\lesson_2\\drivers\\chromedriver.exe");
    WebDriver driver = new ChromeDriver();
    JavascriptExecutor js = (JavascriptExecutor) driver;
    driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
    driver.get("http://192.168.99.100/");
    driver.findElement(By.id("tl_login")).sendKeys("user");
    driver.findElement(By.id("tl_password")).sendKeys("bitnami");
    driver.findElement(By.id("tl_login_button")).click();
    driver.switchTo().frame(1);
    driver.findElement(By.linkText("Test Specification")).click();

    driver.switchTo().frame(1);
    driver.findElement(By.cssSelector(".clickable:nth-child(1)")).click();

    driver.findElement(By.id("new_testsuite")).click();

    driver.findElement(By.id("name")).sendKeys("test_suite");

    driver.findElement(By.name("add_testsuite_button")).click();

    driver.findElement(By.name("go_back")).click();

    driver.findElement(By.cssSelector(".clickable:nth-child(1)")).click();

    //клик по тест съюту
    driver.switchTo().defaultContent();
    driver.switchTo().frame(1);
    driver.switchTo().frame(0);
    driver.findElement(By.xpath("//span[contains(text(),'test_suite (0)')]")).click();

    //клик по шестеренке тест съюта
    driver.switchTo().defaultContent();
    driver.switchTo().frame(1);
    driver.switchTo().frame(1);
    Thread.sleep(1000);
    driver.findElement(By.xpath
            ("//div[@class='workBack']/img[2]")).click();

    //клик по кнопке создания ТК
    driver.findElement(By.id("create_tc")).click();

    //ввод имени ТК
    driver.findElement(By.id("testcase_name")).sendKeys("001");


    driver.findElement(By.id("do_create_button")).click();

    driver.findElement(By.name("create_step")).click();

    Thread.sleep(1000);
    driver.switchTo().frame(0);
    driver.findElement(By.cssSelector(".cke_editable")).click();

    createStepsInTestCase(driver, 3);


    Thread.sleep(5000);  // Let the user actually see something!
    driver.quit();
  }

  private void createStepsInTestCase(WebDriver driver, Integer countOfSteps) {
    for (int i = 0; i < countOfSteps; i++){
      //создание шагов ТК//
        //шаг
      driver.switchTo().defaultContent();
      driver.switchTo().frame(1);
      driver.switchTo().frame(1);
      driver.switchTo().frame(0);
      driver.findElement(By.xpath(
              "//body[@class=\"cke_editable cke_editable_themed cke_contents_ltr cke_show_borders\"]//p"))
              .sendKeys("step_" + i);
        //результат
      driver.switchTo().defaultContent();
      driver.switchTo().frame(1);
      driver.switchTo().frame(1);
      driver.switchTo().frame(1);
      driver.findElement(By.xpath(
              "//body[@class=\"cke_editable cke_editable_themed cke_contents_ltr cke_show_borders\"]//p"))
              .sendKeys("result_" + i);
        //подверждение создания шага
      driver.switchTo().defaultContent();
      driver.switchTo().frame(1);
      driver.switchTo().frame(1);
      driver.findElement(By.id("do_update_step_and_exit")).click();
      if (i == countOfSteps - 1){
        break;
      }
        //инициация создания шага
      driver.switchTo().defaultContent();
      driver.switchTo().frame(1);
      driver.switchTo().frame(1);
      driver.findElement(By.name("create_step")).click();
    }

  }

}
