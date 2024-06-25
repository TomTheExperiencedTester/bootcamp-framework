package browserDriven;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.ContactFormPage;
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

    @Parameters({"subject", "email", "message"})
    @Test
    public void TestSendMessage(String subject, String email, String message){
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
