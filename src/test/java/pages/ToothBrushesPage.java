package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ToothBrushesPage {
    WebDriver driver;

    public ToothBrushesPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(className = "MainHeader__catalog")
    private WebElement catalog;
    @FindBy(partialLinkText = "Красота и здоровье")
    private WebElement beautyAndHealth;
    @FindBy(partialLinkText = "Зубные щетки")
    private WebElement toothBrushes;
    @FindBy(name = "input-min")
    private WebElement min;
    @FindBy(name = "input-max")
    private WebElement max;
    @FindBy(className = "UpsaleBasket__header-link")
    private WebElement cart;

    public void clickCatalogBtn() {
        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.className("MainHeader__catalog")));
        catalog.click();
    }
    public void pointAtCategory() {
        Actions actions = new Actions(driver);
        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("Красота и здоровье")));
        actions.moveToElement(beautyAndHealth).build().perform();
    }
    public void clickToothBrushBtn() {
        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.partialLinkText("Зубные щетки")));
        toothBrushes.click();
    }
    public void setPrices(Integer minP, Integer maxP) {
        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.name("input-min")));
        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.name("input-max")));
        min.clear();
        min.sendKeys(minP.toString());
        max.clear();
        max.sendKeys(maxP.toString());
        max.sendKeys(Keys.ENTER);
    }
    public void clickCartBtn() {
        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.className("UpsaleBasket__header-link")));
        cart.click();
    }
}
