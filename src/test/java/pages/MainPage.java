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

    @FindBy(xpath = "/html/body/div[3]/div[2]/header/div[2]/div[2]/div[2]/div/div[6]/div/div/div[1]/a/div/div[2]")
    private WebElement firstLoginBtn;
    @FindBy(xpath = "//*[@id=\"authorization_popup\"]/div[1]/form/div[4]/div[1]/button/span")
    private WebElement secondLoginBtn;
    @FindBy(xpath = "//*[@id=\"authorization_popup\"]/div[1]/form/div[1]/div/label/input")
    private WebElement loginField;
    @FindBy(xpath = "//*[@id=\"authorization_popup\"]/div[1]/form/div[2]/div/label/input")
    private WebElement passwdField;
    @FindBy(xpath = "/html/body/div[3]/div[2]/header/div[2]/div[2]/div[2]/div/div[6]/div[1]/div/div[1]/div")
    private WebElement userMenu;
    @FindBy (xpath = "/html/body/div[3]/div[2]/header/div[2]/div[2]/div[2]/div/div[6]/div[1]/div/div[2]/div/ul/li[1]/a")
    private WebElement myProfile;
    public void inputLogin(String login) {
        loginField.sendKeys(login);
    }
    public void inputPasswd(String passwd) {
        passwdField.sendKeys(passwd);
    }
    public void clickFirstLoginBtn() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/div[2]/header/div[2]/div[2]/div[2]/div/div[6]/div/div/div[1]/a/div/div[2]")));
        firstLoginBtn.click();
    }
    public void clickSecondLoginBtn() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"authorization_popup\"]/div[1]/form/div[4]/div[1]/button/span")));
        secondLoginBtn.click();
    }
    public String getUserName() {
        return userMenu.getText();
    }
    public void clickUserMenu() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/div[2]/header/div[2]/div[2]/div[2]/div/div[6]/div[1]/div/div[1]/div")));
        userMenu.click();
    }
    public void clickMyProfile() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/div[2]/header/div[2]/div[2]/div[2]/div/div[6]/div[1]/div/div[2]/div/ul/li[1]/a")));
        myProfile.click();
    }
}
