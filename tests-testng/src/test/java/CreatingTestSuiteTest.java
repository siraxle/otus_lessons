import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class CreatingTestSuiteTest extends BaseTest{

  @Test
  public void creatingTestSuite() throws InterruptedException {

    driver.switchTo().frame(1);
    driver.findElement(By.linkText("Test Specification")).click();

    driver.switchTo().frame(1);
    driver.findElement(By.cssSelector(".clickable:nth-child(1)")).click();

    driver.findElement(By.id("new_testsuite")).click();

    driver.findElement(By.id("name")).sendKeys("test_suite");

    driver.findElement(By.name("add_testsuite_button")).click();

    driver.findElement(By.name("go_back")).click();

    driver.findElement(By.cssSelector(".clickable:nth-child(1)")).click();

    createTestCase(driver, "001");
    createStepsInTestCase(driver, 3);

    createTestCase(driver, "002");
    createStepsInTestCase(driver, 3);
  }

  private void createTestCase(WebDriver driver, String testCaseName) throws InterruptedException {
    //клик по тест съюту
    testSuiteClick();
    //клик по шестеренке тест съюта
    gearTestSuiteClick();
    //клик по кнопке создания ТК
    driver.findElement(By.id("create_tc")).click();

    //ввод имени ТК
    driver.findElement(By.id("testcase_name")).sendKeys(testCaseName);

    driver.findElement(By.id("do_create_button")).click();


  }

  private void createStepsInTestCase(WebDriver driver, Integer countOfSteps) throws InterruptedException {
    driver.findElement(By.name("create_step")).click();

    Thread.sleep(1000);
    driver.switchTo().frame(0);
    driver.findElement(By.cssSelector(".cke_editable")).click();

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
