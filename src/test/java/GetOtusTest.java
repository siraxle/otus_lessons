import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetOtusTest {
  private static final Logger logger = LogManager.getLogger(GetOtusTest.class.getName());

  @Test
  public void testOtusSearch() throws InterruptedException {
    logger.info("Start test testOtusSearch");
    logger.debug("debug");
    logger.error("error");
    logger.warn("warn");
    System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
    WebDriver driver = new ChromeDriver();
    driver.get("https://otus.ru/");
    Thread.sleep(5000);  // Let the user actually see something!
    driver.quit();
    logger.info("Stop test testOtusSearch");
  }
}
