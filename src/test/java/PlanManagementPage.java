import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class PlanManagementPage extends BasePage{
    private UserSettings userSettings;
    public PlanManagementPage(ChromeDriver driver,UserSettings userSettings) {
        super(driver);
        this.userSettings=userSettings;
    }
    public UserSettings edit() throws InterruptedException {
        this.waitAndReturnElement(By.id("shpro-subscription-item-price_1IRFlaFBnEB7TjpwHT3rEI71")).click();
        this.pageWait(1000);
        this.waitAndReturnElement(By.id("shpro-subscription-item-price_1IaKmSFBnEB7Tjpw63JpgRro")).click();
        this.pageWait(1000);
        this.goBack();
        this.pageWait(2000);
        return userSettings;
    }

    @Override
    public Boolean openedCorrectly() throws InterruptedException {
        this.pageWait(1000);
        return this.getBodyText().contains("Selecciona tu plan");
    }
}
