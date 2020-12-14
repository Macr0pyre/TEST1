package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPage {
    public WebDriver driver;
    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(className = "AuthPopup")
    private WebElement firstLoginBtn;
    @FindBy(className = "SignIn__action")
    private WebElement secondLoginBtn;
    @FindBy(name = "login")
    private WebElement loginField;
    @FindBy(name = "pass")
    private WebElement passwdField;
    @FindBy(className = "HeaderUserName")
    private WebElement userMenu;
    @FindBy (partialLinkText = "Мой профиль")
    private WebElement myProfile;

    public void inputLogin(String login) {
        loginField.sendKeys(login);
    }
    public void inputPasswd(String passwd) {
        passwdField.sendKeys(passwd);
    }
    public void clickFirstLoginBtn() {
        firstLoginBtn.click();
    }
    public void clickSecondLoginBtn() {
        secondLoginBtn.click();
    }
    public String getUserName() {
        return userMenu.getText();
    }
    public void clickUserMenu() {
        userMenu.click();
    }
    public void clickMyProfile() {
        myProfile.click();
    }
}
