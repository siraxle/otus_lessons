import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
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
    TestProjectModel testProjectModel = new TestProjectModel("name_1", "q_",
            "description_1", true);
    driver.findElement(By.name("tprojectName")).sendKeys(testProjectModel.name);
    driver.findElement(By.name("tcasePrefix")).sendKeys(testProjectModel.prefix);
    driver.switchTo().frame(0);
    driver.findElement(By.xpath
            ("//body[@class=\"cke_editable cke_editable_themed cke_contents_ltr cke_show_borders\"]/p"))
            .sendKeys(testProjectModel.projectDescription);
    if (!testProjectModel.isPublic){
      driver.switchTo().defaultContent();
      driver.switchTo().frame(1);
      driver.findElement(By.xpath("//table[@id=\"item_view\"]//input[@name=\"is_public\"]"))
              .click();
    }
    //клик по кнопке создания тест проекта
    driver.switchTo().defaultContent();
    driver.switchTo().frame(1);
    driver.findElement(By.name("doActionButton")).click();

    List<WebElement> rows = new ArrayList<WebElement>();
    rows = driver.findElements(By.xpath("//table[@id=\"item_view\"]/tbody/tr"));
    for (int i = 0; i < rows.size(); i++){
      String name = rows.get(i).findElement(By.xpath("//td[@class=\"sorting_1\"]/a")).getText();
      if (testProjectModel.name.equals(name)){
        System.out.println("!!success!!");
      }
    }

  }

}
