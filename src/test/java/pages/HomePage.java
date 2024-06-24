package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    @FindBy(className = "login")
    private WebElement loginButton;
    @FindBy(id = "email")
    private WebElement emailAddressTextbox;
    @FindBy(id = "passwd")
    private WebElement passwordTextbox;
    @FindBy(id = "SubmitLogin")
    private WebElement signinButton;
    @FindBy(css = "a.logout")
    private WebElement signoutButton;
    @FindBy(css = "li#header_link_contact > a[title='contact']")
    private WebElement contactLink;
    @FindBy(css = "a[title='My wishlists']")
    private WebElement myWishListsButton;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void login(String email, String password){
        loginButton.click();
        emailAddressTextbox.sendKeys(email);
        passwordTextbox.sendKeys(password);
        signinButton.click();
    }

    public void goToContactFormPage(){
        contactLink.click();
    }

    public void goToWishLists(){
        myWishListsButton.click();
    }
}
