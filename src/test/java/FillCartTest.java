import io.github.bonigarcia.wdm.WebDriverManager;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;

import java.time.Duration;
import java.util.List;

public class FillCartTest extends TestShopScenario{

    private final String EMAIL_ADDRESS = "tom.vandesteene@polteq.com";
    private final String PASSWORD = "Nina2";

    @Test
    public void FillCart() {
        // Navigate to the website
        HomePage homePage = new HomePage(driver);
        homePage.login(EMAIL_ADDRESS, PASSWORD);
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

    /*@AfterMethod
    public void tearDown() {
        //Close the browser
        if (driver != null) {
            driver.quit();
        }
    }*/
}
