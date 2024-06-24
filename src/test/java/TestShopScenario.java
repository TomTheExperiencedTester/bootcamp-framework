import io.github.bonigarcia.wdm.WebDriverManager;
import lib.Browser;
import lib.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public abstract class TestShopScenario {
    protected WebDriver driver;
    protected final String BASE_URL = "https://greatshop.polteq-testing.com/";

    @BeforeMethod
    public void setup(){
        // Set up ChromeDriver using WebDriverManager
        driver = DriverFactory.createDriver(Browser.CHROME);
        driver.manage().window().maximize();
    }

    @Test
    public void startTest(){
        driver = DriverFactory.createDriver(Browser.CHROME);
    }

    /*@AfterMethod
    public void tearDown(){
        driver.quit();
    }*/
}
