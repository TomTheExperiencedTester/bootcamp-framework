import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CreateWishListTest {
    private WebDriver driver;
    private final String BASE_URL = "https://greatshop.polteq-testing.com/";

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void createWishList() {
        login();

        // Navigate to the wishlist page
        driver.findElement(By.cssSelector("a[title='My wishlists']")).click();

        // Create a new wishlist
        WebElement wishlistNameTextbox = driver.findElement(By.id("name"));
        wishlistNameTextbox.sendKeys("Another List");

        WebElement saveWishlistButton = driver.findElement(By.id("submitWishlist"));
        saveWishlistButton.click();
    }

    @Test(dependsOnMethods = {"createWishList"})
    public void deleteWishlist() {
        login();

        // Navigate to the wishlist page
        driver.findElement(By.cssSelector("a[title='My wishlists']")).click();

        // Find the wishlist and delete it
        WebElement wishlistLink = driver.findElement(By.linkText("Feel the pain"));
        WebElement wishlistRow = wishlistLink.findElement(By.xpath("./ancestor::tr"));

        // Find and click the delete link in this row
        WebElement deleteLink = wishlistRow.findElement(By.cssSelector(".wishlist_delete a"));
        deleteLink.click();

        // Handle any confirmation dialog (if present)
        // In this example, we assume it directly deletes without confirmation

        // Optional: Wait for some time after deletion
        try {
            Thread.sleep(2000); // Adjust as needed
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Wishlist 'Feel the pain' deleted successfully.");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    private void login() {
        driver.get(BASE_URL);

        // Click on the login link
        driver.findElement(By.className("login")).click();

        // Enter email address and password
        driver.findElement(By.id("email")).sendKeys("tom.vandesteene@polteq.com");
        driver.findElement(By.id("passwd")).sendKeys("Nina2");

        // Click the sign-in button
        driver.findElement(By.id("SubmitLogin")).click();
    }
}
