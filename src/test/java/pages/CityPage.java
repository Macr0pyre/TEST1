package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

public class CityPage {
    public WebDriver driver;
    public CityPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver; }

    @FindBy(xpath = "/html/body/div[2]/div[2]/header/div[1]/div[2]/div[1]/div[3]/button")
    private  WebElement city;
    @FindBy(xpath = "/html/body/div[3]/div[2]/header/div[1]/div[2]/div[1]/div[6]/div[2]/div/div/div/div[3]/div[12]/ul/li[1]/a")
    private  WebElement kazan;
    @FindBy(xpath = "//*[@id=\"content\"]/div/div[2]/div/div/span")
    private WebElement address;
    @FindBy(xpath = "//*[@id=\"content\"]/div/div[2]/div/div/form/div[1]/div[2]")
    private WebElement myCity;
    public void clickChangeCity() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div[2]/header/div[1]/div[2]/div[1]/div[3]/button")));
        city.click(); }
    public void clickKazan() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[3]/div[2]/header/div[1]/div[2]/div[1]/div[6]/div[2]/div/div/div/div[3]/div[12]/ul/li[1]/a")));
        kazan.click(); }
    public String getCityName() {
        String cityName = city.getText();
        return new String(cityName.getBytes(StandardCharsets.UTF_8)); }
    public void clickAddress() {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"content\"]/div/div[2]/div/div/span")));
        address.click();
    }
    public String getCityInAddress() {
        String cityName = myCity.getText();
        return new String(cityName.getBytes(StandardCharsets.UTF_8)); }
}

