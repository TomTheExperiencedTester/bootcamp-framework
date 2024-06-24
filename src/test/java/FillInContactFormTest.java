import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ContactFormPage;
import pages.HomePage;

public class FillInContactFormTest {
    private WebDriver driver;
    private final String BASE_URL = "https://greatshop.polteq-testing.com/";
    private final String EMAIL_ADDRESS = "tom.vandesteene@polteq.com";
    private final String PASSWORD = "Nina2";

    @BeforeMethod
    public void setUp() {
        // Set up ChromeDriver using WebDriverManager
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();

    }

    @Test
    public void TestContactFormPage(){
        driver.get(BASE_URL);
        HomePage homePage = new HomePage(driver);
        homePage.login(EMAIL_ADDRESS, PASSWORD);
        homePage.goToContactFormPage();
    }

    @Test
    public void TestSelectCustomerService(){
        driver.get(BASE_URL);
        HomePage homePage = new HomePage(driver);
        homePage.login(EMAIL_ADDRESS, PASSWORD);
        homePage.goToContactFormPage();
        ContactFormPage contactFormPage = new ContactFormPage(driver);
        contactFormPage.selectDropdownOption();
    }
    @Test
    public void TestSendMessage(){
        driver.get(BASE_URL);
        HomePage homePage = new HomePage(driver);
        homePage.login(EMAIL_ADDRESS, PASSWORD);
        homePage.goToContactFormPage();
        ContactFormPage contactFormPage = new ContactFormPage(driver);
        contactFormPage.sendAMessage();
        String expectedMessage = "Your message has been successfully sent to our team.";
        String actualMessage = contactFormPage.getSuccesMessage();

        // Verifieer of het verwachte bericht overeenkomt met het werkelijke bericht
        Assert.assertEquals(actualMessage, expectedMessage, "Het succesbericht komt overeen.");
    }
}
