import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class TestShopScenario {
    protected WebDriver driver;
    protected final String BASE_URL = "https://greatshop.polteq-testing.com/";

    @BeforeMethod
    public void setup(){
        // Set up ChromeDriver using WebDriverManager
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(BASE_URL);
        driver.manage().window().maximize();
    }

    /*@AfterMethod
    public void tearDown(){
        driver.quit();
    }*/
}
