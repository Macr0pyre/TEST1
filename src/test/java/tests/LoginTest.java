package tests;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import properties.ConfProperties;
import pages.MainPage;
import pages.CityPage;
import java.util.concurrent.TimeUnit;

public class LoginTest {
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
    public void loginTest() throws InterruptedException {
        mainPage.clickFirstLoginBtn();
        mainPage.inputLogin(ConfProperties.getProperty("login"));
        mainPage.inputPasswd(ConfProperties.getProperty("password"));
        Thread.sleep(10000);
        mainPage.clickSecondLoginBtn();
        String user = mainPage.getUserName();
        Assert.assertEquals(ConfProperties.getProperty("name"), user);
    }

    @AfterClass
    public static void ExitDriver()
    {
        driver.quit();
    }
}
