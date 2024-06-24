import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ContactFormPage;
import pages.HomePage;

public class FillInContactFormTest extends TestShopScenario{

    private final String EMAIL_ADDRESS = "tom.vandesteene@polteq.com";
    private final String PASSWORD = "Nina2";



    @Test
    public void TestContactFormPage(){
        HomePage homePage = new HomePage(driver);
        homePage.login(EMAIL_ADDRESS, PASSWORD);
        homePage.goToContactFormPage();
    }

    @Test
    public void TestSelectCustomerService(){
        HomePage homePage = new HomePage(driver);
        homePage.login(EMAIL_ADDRESS, PASSWORD);
        homePage.goToContactFormPage();
        ContactFormPage contactFormPage = new ContactFormPage(driver);
        contactFormPage.selectDropdownOption();
    }
    @Test
    public void TestSendMessage(){
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
