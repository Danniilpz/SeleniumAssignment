import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class MainPage extends BasePage{
    public MainPage(ChromeDriver driver) throws InterruptedException {
        super(driver);
    }

    @Override
    public Boolean openedCorrectly() throws InterruptedException {
        this.pageWait(1000);
        return this.getBodyText().contains("Wuolers recomendados");
    }

    public UserPage user() throws InterruptedException {
        this.waitAndReturnElement(By.id("nav_user_avatar")).click();
        return new UserPage(driver,this);
    }
}
