import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;

public class ClickAccessoiresTest extends TestShopScenario{
    private final String EMAIL_ADDRESS = "tom.vandesteene@polteq.com";
    private final String PASSWORD = "Nina2";

    @Test
    public void clickAccessories(){

        HomePage homepage = new HomePage(driver);
        homepage.login(EMAIL_ADDRESS, PASSWORD);
        // Zoek de "Accessories" knop
        WebElement accessoriesButton = driver.findElement(By.cssSelector("ul.sf-menu > li > a[title='Accessories']"));

        // Voer acties uit op de gevonden knop, bijvoorbeeld klikken
        accessoriesButton.click();

    }
}
