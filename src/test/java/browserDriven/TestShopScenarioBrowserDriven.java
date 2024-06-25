package browserDriven;

import lib.Browser;
import lib.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public abstract class TestShopScenarioBrowserDriven {
    protected WebDriver driver;
    protected final String BASE_URL = "https://greatshop.polteq-testing.com/";

    @Parameters({"browser"})
    @BeforeMethod
    public void setup(Browser browser){
        // Set up ChromeDriver using WebDriverManager
        driver = DriverFactory.createDriver(browser);
        driver.manage().window().maximize();
        driver.get(BASE_URL);
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }
}
