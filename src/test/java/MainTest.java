import com.sun.source.tree.AssertTree;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainTest {
    private ChromeDriver driver;
    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();

        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }
    @After
    public void close() {
        if (driver != null) {
            driver.quit();
        }
    }
    @Test
    public void testSelenium() throws InterruptedException {
        //initial page
        InitialPage init=new InitialPage(driver);
        init.open();
        Assert.assertTrue("Init page opened correctly",init.openedCorrectly());
        Assert.assertTrue("Correct title",driver.getTitle().contains("Wuolah"));
        //static pages
        StaticPage staticPage=new StaticPage(driver);
        String[] statics={"https://www.wuolah.com/es/selectividad-ebau/", "https://www.wuolah.com/es/universidades", "https://brands.wuolah.com/"};
        for(String s:statics){
            staticPage.setLink(s);
            Assert.assertTrue("Static page opened correctly",staticPage.openedCorrectly());
        }
        //login
        init.open();
        LoginPage login=init.login();
        Assert.assertTrue("Login page opened correctly",login.openedCorrectly());
        String email="wogoh51323@chokxus.com";
        String password="Test12345";
        MainPage main=login.login(email,password);
        Assert.assertTrue("Main page opened correctly",main.openedCorrectly());
        //user settings
        UserPage user=main.user();
        Assert.assertTrue("User page opened correctly",user.openedCorrectly());
        UserSettings userSettings=user.settings();
        Assert.assertTrue("User settings page opened correctly",userSettings.openedCorrectly());
        userSettings.editBio();
        userSettings.editGender();
        PlanManagementPage planManagement=userSettings.editPlanManagement();
        Assert.assertTrue("Plan management page opened correctly",planManagement.openedCorrectly());
        userSettings=planManagement.edit();
        user=userSettings.goMainUserPage();
        Assert.assertTrue("User page opened correctly",user.openedCorrectly());
        //logout
        init=user.logout();
        Assert.assertTrue("Init page opened correctly",init.openedCorrectly());
    }


}
