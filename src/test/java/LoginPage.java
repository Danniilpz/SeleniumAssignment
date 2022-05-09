import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginPage extends BasePage{
    public LoginPage(ChromeDriver driver) {
        super(driver);
    }

    @Override
    public Boolean openedCorrectly() throws InterruptedException {
        this.pageWait(1000);
        return this.getBodyText().contains("Accede con");
    }

    public MainPage login(String email,String password) throws InterruptedException {
        this.waitAndReturnElement(By.id("email_login")).sendKeys(email);
        this.waitAndReturnElement(By.id("password_login")).sendKeys(password);
        this.waitAndReturnElement(By.cssSelector("button[onclick='loginForm(); return false;']")).click();
        this.pageWait(20000);
        if(driver.findElements(By.id("rf_go_to_wuolah_button")).size() != 0)
            this.waitAndReturnElement(By.id("rf_go_to_wuolah_button")).click();
        if(driver.findElements(By.id("onesignal-slidedown-cancel-button")).size() != 0)
            this.waitAndReturnElement(By.id("onesignal-slidedown-cancel-button")).click();
        return new MainPage(driver);
    }
}
