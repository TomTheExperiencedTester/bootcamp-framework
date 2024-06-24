import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ClickAccessoiresTest {
    private WebDriver driver;
    private final String BASE_URL = "https://greatshop.polteq-testing.com/";

    @BeforeMethod
    public void setUp() {
        // Set up ChromeDriver using WebDriverManager
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void clickAccessories(){
        driver.get(BASE_URL);
        driver.findElement(By.className("login")).click();
        WebElement emailAddressTextbox = driver.findElement(By.id("email"));
        emailAddressTextbox.sendKeys("tom.vandesteene@polteq.com");
        WebElement PasswordTextbox = driver.findElement(By.id("passwd"));
        PasswordTextbox.sendKeys("Nina2");
        WebElement signinButton = driver.findElement(By.id("SubmitLogin"));
        signinButton.click();

        // Zoek de "Accessories" knop
        WebElement accessoriesButton = driver.findElement(By.cssSelector("ul.sf-menu > li > a[title='Accessories']"));

        // Voer acties uit op de gevonden knop, bijvoorbeeld klikken
        accessoriesButton.click();

    }
}
