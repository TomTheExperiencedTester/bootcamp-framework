import io.github.bonigarcia.wdm.WebDriverManager;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;

import java.time.Duration;
import java.util.List;

public class FirstSeleniumTest extends TestShopScenario {

    private final String EMAIL_ADDRESS = "tom.vandesteene@polteq.com";
    private final String PASSWORD = "Nina2";

    @Test
    public void testHomePageTitle() {
        // Navigate to the website
        // Check the title of the page
        String PAGE_TITLE = "Polteq Mission Critical Testing - TEST webshop - Polteq's Great TestShop";
        Assert.assertEquals(driver.getTitle(), PAGE_TITLE);
    }

    @Test
    public void testLoginSuccessful() {
        HomePage homepage = new HomePage(driver);
        // Navigate to the website
        homepage.login(EMAIL_ADDRESS, PASSWORD);
        List<WebElement> signoutButtons = driver.findElements(By.className("logout"));
        Assert.assertEquals(signoutButtons.size(), 1);
    }

    @Test
    public void testLoginUnsuccessful() {}

    @Test
    public void testSignout() {
        driver.get(BASE_URL);
        driver.findElement(By.className("login")).click();
        WebElement emailAddressTextbox = driver.findElement(By.id("email"));
        emailAddressTextbox.sendKeys("tom.vandesteene@polteq.com");
        WebElement PasswordTextbox = driver.findElement(By.id("passwd"));
        PasswordTextbox.sendKeys("Nina2");
        WebElement signinButton = driver.findElement(By.id("SubmitLogin"));
        signinButton.click();
        WebElement signoutButton = driver.findElement(By.cssSelector("a.logout"));
        signoutButton.click();
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(signinButton));
        List<WebElement> signinButtons = driver.findElements(By.className("login"));
        Assert.assertTrue(!signinButtons.isEmpty());
    }
}


