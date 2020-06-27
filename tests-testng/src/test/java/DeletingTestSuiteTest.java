import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class DeletingTestSuiteTest extends BaseTest {

  @Test
  public void deletingTestSuiteTest() throws InterruptedException {
    driver.switchTo().frame(1);
    driver.findElement(By.linkText("Test Specification")).click();
    testSuiteClick();
    gearTestSuiteClick();
    deleteTestSuiteWithAllChildren();
  }

}
