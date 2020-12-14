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
    private WebElement newCity;
    public CityPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver; }

    @FindBy(className = "MainHeader__city")
    private  WebElement city;
    @FindBy(className = "delivery_address")
    private WebElement address;
    public void clickChangeCity() {
        city.click(); }
    public String getCityName() {
        String cityName = city.getText();
        return new String(cityName.getBytes(StandardCharsets.UTF_8)); }
    public String getDeliveryAddress(){
        return address.getText().split(",")[0];
    }
    public void clickCity(String city_name) {
        newCity = driver.findElement(By.partialLinkText(city_name));
        newCity.click();
    }
}

