package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    private WebDriver driver;

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
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
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
