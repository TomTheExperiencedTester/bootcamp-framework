import io.github.bonigarcia.wdm.WebDriverManager;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class FillCartTest {
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
    public void FillCart() {
        // Navigate to the website
        driver.get(BASE_URL);
        driver.get(BASE_URL);
        driver.findElement(By.className("login")).click();
        WebElement emailAddressTextbox = driver.findElement(By.id("email"));
        emailAddressTextbox.sendKeys("tom.vandesteene@polteq.com");
        WebElement PasswordTextbox = driver.findElement(By.id("passwd"));
        PasswordTextbox.sendKeys("Nina2");
        WebElement signinButton = driver.findElement(By.id("SubmitLogin"));
        signinButton.click();
        List<WebElement> signoutButtons = driver.findElements(By.className("logout"));
        Assert.assertEquals(signoutButtons.size(), 1);
        WebElement shoppingCart = driver.findElement(By.cssSelector("a[href='https://greatshop.polteq-testing.com/index.php?controller=order']"));;
        Assertions.assertThat(shoppingCart.isDisplayed());
        WebElement ipodTag = driver.findElement(By.cssSelector("a[title=\"More about ipod\"]"));
        ipodTag.click();
        WebElement ipodShuffleImage = driver.findElement(By.cssSelector("img[title=\"iPod shuffle\"]\n"));
        ipodShuffleImage.click();
        WebElement addToCartButton = driver.findElement(By.cssSelector("button[type='submit'][name='Submit'].exclusive"));
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(addToCartButton));
        addToCartButton.click();
        WebElement proceedToCheckoutButton = driver.findElement(By.cssSelector("a.btn.btn-default.button.button-medium[href='https://greatshop.polteq-testing.com/index.php?controller=order'][title='Proceed to checkout'][rel='nofollow']"));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(proceedToCheckoutButton));
        proceedToCheckoutButton.click();
        WebElement filledCart = driver.findElement(By.cssSelector(".ajax_cart_quantity"));
        webDriverWait.until(ExpectedConditions.elementToBeClickable(filledCart));
        List<WebElement> filledCarts = driver.findElements(By.cssSelector(".ajax_cart_quantity"));
        Assertions.assertThat(filledCarts.size()).isGreaterThan(0);
    }
}
