package tests;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import properties.ConfProperties;
import pages.CityPage;
import pages.MainPage;

import java.util.Arrays;
import java.util.Collection;
import java.util.concurrent.TimeUnit;

@RunWith(value = Parameterized.class)
public class ChangeCityTest {
    private String city;
    public static MainPage mainPage;
    public static CityPage cityPage;
    public static WebDriver driver;

    public ChangeCityTest(String city)
    {
        this.city = city;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> GetParams()
    {
        return Arrays.asList(new Object[][]{
                {"Казань"},
                {"Минеральные Воды"},
                {"Абакан"}
        });
    }

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
        cityPage.clickCity(city);
        String onPageCity = cityPage.getCityName();
        Assert.assertEquals(city, onPageCity);
        mainPage.clickFirstLoginBtn();
        mainPage.inputLogin(ConfProperties.getProperty("login"));
        mainPage.inputPasswd(ConfProperties.getProperty("password"));
        Thread.sleep(10000);
        mainPage.clickSecondLoginBtn();
        mainPage.clickUserMenu();
        mainPage.clickMyProfile();
        String cityInAddress = cityPage.getDeliveryAddress();
        try{
            Assert.assertEquals(onPageCity, cityInAddress);
        }
        catch (ComparisonFailure cat){
            cat.getStackTrace();
        }
        finally {
            mainPage.logout();
        }
    }

    @AfterClass
    public static void ExitDriver()
    {
        driver.quit();
    }
}
