import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;

public class UserPage extends BasePage{
    public UserPage(ChromeDriver driver,MainPage main) throws InterruptedException {
        super(driver);
    }
    public UserSettings settings() throws InterruptedException {
        this.waitAndReturnElement(By.xpath("//button[contains(@class,'header-settings-button')]")).click();
        return new UserSettings(driver,this);
    }
    public InitialPage logout() throws InterruptedException {
        this.waitAndReturnElement(By.xpath("//button[contains(@class,'header-exit-button')]")).click();
        this.pageWait(4000);
        return new InitialPage(driver);
    }

    @Override
    public Boolean openedCorrectly() throws InterruptedException {
        this.pageWait(4000);
        return this.getBodyText().contains("user_2894354");
    }
}
