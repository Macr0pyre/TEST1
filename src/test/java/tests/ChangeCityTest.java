package tests;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import properties.ConfProperties;
import pages.CityPage;
import pages.MainPage;
import java.util.concurrent.TimeUnit;

public class ChangeCityTest {
    public static MainPage mainPage;
    public static CityPage cityPage;
    public static WebDriver driver;

    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
        driver = new ChromeDriver();
        mainPage = new MainPage(driver);
        cityPage = new CityPage(driver);
        //окно разворачивается на полный экран
        driver.manage().window().maximize();
        //задержка на выполнение теста = 10 сек.
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(ConfProperties.getProperty("loginpage"));
    }

    @Test
    public void changeCityTest() throws InterruptedException {
        cityPage.clickChangeCity();
        cityPage.clickCity(ConfProperties.getProperty("city"));
        String city = cityPage.getCityName();
        Assert.assertEquals(ConfProperties.getProperty("city"), city);
        mainPage.clickFirstLoginBtn();
        mainPage.inputLogin(ConfProperties.getProperty("login"));
        mainPage.inputPasswd(ConfProperties.getProperty("password"));
        Thread.sleep(5000);
        mainPage.clickSecondLoginBtn();
        mainPage.clickUserMenu();
        mainPage.clickMyProfile();
        String cityInAddress = cityPage.getDeliveryAddress();
        Assert.assertEquals(city, cityInAddress);
    }

    @AfterClass
    public static void ExitDriver()
    {
        driver.quit();
    }
}
