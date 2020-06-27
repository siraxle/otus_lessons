import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class CheckProjectTableTest extends BaseTest{

  @Test
  public void checkProjectTableTest() {
    //клик по кнопке "Test Project Management"
    driver.switchTo().frame(1);
    driver.findElement(By.linkText("Test Project Management")).click();
    //инициация создания тестового проекта
    driver.findElement(By.id("create")).click();
    //создание тест проекта через заполнение формы
    TestProjectModel testProjectModelbefore = new TestProjectModel("name_1", "q_",
            "description_1", true);
    driver.findElement(
            By.name("tprojectName")).sendKeys(testProjectModelbefore.name);
    driver.findElement(By.name("tcasePrefix")).sendKeys(testProjectModelbefore.prefix);
    driver.switchTo().frame(0);
    driver.findElement(By.xpath
            ("//body[@class=\"cke_editable cke_editable_themed cke_contents_ltr cke_show_borders\"]/p"))
            .sendKeys(testProjectModelbefore.projectDescription);
    if (!testProjectModelbefore.isPublic){
      driver.switchTo().defaultContent();
      driver.switchTo().frame(1);
      driver.findElement(By.xpath("//table[@id=\"item_view\"]//input[@name=\"is_public\"]"))
              .click();
    }
    //клик по кнопке создания тест проекта
    driver.switchTo().defaultContent();
    driver.switchTo().frame(1);
    driver.findElement(By.name("doActionButton")).click();

    //Создание объекта типа TestProjectModel собирая данные из страницы со списком
    List<WebElement> rows = new ArrayList<WebElement>();
    rows = driver.findElements(By.xpath("//table[@id=\"item_view\"]/tbody/tr"));
    TestProjectModel testProjectModelAfter = new TestProjectModel();
    for (int i = 0; i < rows.size(); i++){
      String name = rows.get(i).findElement(By.xpath("td[@class=\"sorting_1\"]/a"))
              .getText();
      String description = rows.get(i).findElement(By.xpath("td[2]/p")).getText();
      String prefix = rows.get(i).findElement(By.xpath("td[3]")).getText();
      String isPublicString = rows.get(i).findElement(By.xpath("td[8]")).getText();
      boolean isPublic;
      if (isPublicString.equals(" ")){
        isPublic = false;
      } else isPublic = true;
      if (testProjectModelbefore.name.equals(name) &&
              testProjectModelbefore.projectDescription.equals(description) &&
              testProjectModelbefore.prefix.equals(prefix) &&
              testProjectModelbefore.isPublic.equals(isPublic)){
        System.out.println(i + " итерация");
        testProjectModelAfter.setName(name);
        testProjectModelAfter.setProjectDescription(description);
        testProjectModelAfter.setPrefix(prefix);
        testProjectModelAfter.setPublic(isPublic);
        System.out.println(testProjectModelAfter);
      }
    }

    Assert.assertEquals(testProjectModelAfter, testProjectModelbefore);


  }

}
