import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ClickIPodsInCategoriesTest extends TestShopScenario{



    @Test
    public void clickIPodsInCategories() {
        driver.get(BASE_URL);
        driver.findElement(By.className("login")).click();
        WebElement emailAddressTextbox = driver.findElement(By.id("email"));
        emailAddressTextbox.sendKeys("tom.vandesteene@polteq.com");
        WebElement PasswordTextbox = driver.findElement(By.id("passwd"));
        PasswordTextbox.sendKeys("Nina2");
        WebElement signinButton = driver.findElement(By.id("SubmitLogin"));
        signinButton.click();

// Wacht tot het element zichtbaar is voordat je het probeert te vinden
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)); // Wacht maximaal 10 seconden
        WebElement iPodsLink = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='categories_block_left']//ul[@class='dynamized']/li/a[text()=' iPods ']")));

// Voer acties uit op de gevonden link, bijvoorbeeld klikken
        iPodsLink.click();
    }
}
