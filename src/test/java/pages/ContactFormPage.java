package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ContactFormPage {
    private WebDriver driver;

    @FindBy(css = "select#id_contact")
    private  WebElement subjectHeadingDropdown;
    @FindBy(css = "button#submitMessage")
    private WebElement sendButton;
    @FindBy(id = "message")
    private WebElement messageTextArea;

    @FindBy(css = "p.alert.alert-success")
    private WebElement succesMessage;

    public ContactFormPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }
    public String getSuccesMessage() {
        return succesMessage.getText();
    }

    public void selectDropdownOption(){

        // Maak een Select object
        Select select = new Select(subjectHeadingDropdown);

        // Selecteer een optie op basis van zichtbare tekst
        select.selectByVisibleText("Customer Service");

        // Optioneel: Verificaties of verdere acties na het selecteren
        System.out.println("Option 'Customer Service' selected successfully.");
    }

    public void sendAMessage(){
        selectDropdownOption();
        messageTextArea.sendKeys("Ingevuld door mezelf!");
        sendButton.click();
        if(succesMessage.isDisplayed()){
            System.out.println("Sendmessage is geslaagd!");
        }else{
            System.out.println("Sendmessage is gefaald!");
        }
    }
}
