package tests;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.ToothBrushesPage;
import properties.ConfProperties;

import java.util.concurrent.TimeUnit;

public class ToothBrushesTest {
    public static ToothBrushesPage toothBrushesPage;
    public static WebDriver driver;

    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
        driver = new ChromeDriver();
        toothBrushesPage = new ToothBrushesPage(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(ConfProperties.getProperty("loginpage"));
    }

    @Test
    public void ToothbrushSearchTest() {
        toothBrushesPage.clickCatalogBtn();
        toothBrushesPage.pointAtCategory();
        toothBrushesPage.clickToothBrushBtn();
        toothBrushesPage.clickToothBrushBtn();
        toothBrushesPage.setPrices(999, 1999);
        //toothBrushesPage.clickCartBtn();
    }

    @AfterClass
    public static void ExitDriver()
    {
        driver.quit();
    }
}
