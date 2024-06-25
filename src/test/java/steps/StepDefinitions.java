package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lib.Browser;
import lib.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.HomePage;

import java.util.List;

public class StepDefinitions {

    private WebDriver driver;
    private WebDriverWait wait;
    private HomePage homePage;

    protected final String EMAIL_ADDRESS = "tom.vandesteene@polteq.com";
    protected final String PASSWORD = "Nina2";
    protected final String BASE_URL = "https://greatshop.polteq-testing.com/";

    @Before
    public void init(){
        driver = DriverFactory.createDriver(Browser.CHROME);
        homePage = new HomePage(driver);
        driver.manage().window().maximize();
    }
    @Given("I am on the Polteq Great testshop")
    public void iAmOnThePolteqGreatTestshop() {
        driver.get(BASE_URL);
    }

    @When("I log in as a valid user")
    public void iLogInAsAValidUser() {
        homePage.login(EMAIL_ADDRESS,PASSWORD);
    }

    @Then("I should be logged in")
    public void iShouldBeLoggedIn() {
        List<WebElement> signoutButtons = driver.findElements(By.className("logout"));
        Assert.assertEquals(signoutButtons.size(), 1);
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
