package package1;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public WebDriver driver;
    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver; }

    @FindBy(xpath = "//*[@id=\"login_form_show_js\"]")
    private WebElement firstLoginBtn;
    @FindBy(xpath = "//*[@id=\"authorization_popup\"]/div/form/div[2]/div/button")
    private WebElement secondLoginBtn;
    @FindBy(xpath = "//*[@id=\"login\"]")
    private WebElement loginField;
    @FindBy(xpath = "//*[@id=\"pass\"]")
    private WebElement passwdField;
    public void inputLogin(String login) {
        loginField.sendKeys(login); }
    public void inputPasswd(String passwd) {
        passwdField.sendKeys(passwd); }
    public void clickFirstLoginBtn() {
        firstLoginBtn.click(); }
    public void clickSecondLoginBtn() {
        secondLoginBtn.click(); }
}
