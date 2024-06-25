package browserDriven;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;

import java.util.List;

public class BrowserDrivenTest extends TestShopScenarioBrowserDriven{

    private final String EMAIL_ADDRESS = "tom.vandesteene@polteq.com";
    private final String PASSWORD = "Nina2";

    @Test
    public void testLoginSuccessful() {
        HomePage homepage = new HomePage(driver);
        // Navigate to the website
        homepage.login(EMAIL_ADDRESS, PASSWORD);
        List<WebElement> signoutButtons = driver.findElements(By.className("logout"));
        Assert.assertEquals(signoutButtons.size(), 1);
    }
}
