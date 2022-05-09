import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;

public class UserSettings extends BasePage{
    private UserPage userPage;
    public UserSettings(ChromeDriver driver,UserPage userPage) throws InterruptedException {
        super(driver);
        this.userPage=userPage;
    }
    public void editBio(){
        this.waitAndReturnElement(By.xpath("//div[contains(@class,'editable-bio-template')]")).click();
        this.waitAndReturnElement(By.id("edit_bio")).sendKeys("testBio");
        this.waitAndReturnElement(By.xpath("//*[@id='settingsSection']/div[1]/div[1]/div[4]/div[4]/button[2]")).click();
    }
    public void editGender(){
        this.waitAndReturnElement(By.xpath("//div[contains(@class,'editable-gender-template')]")).click();
        this.waitAndReturnElement(By.xpath("//li//span[contains(text(),'Masculino')]")).click();
        this.waitAndReturnElement(By.xpath("//*[@id='settingsSection']/div[1]/div[1]/div[5]/div[4]/button[2]")).click();
    }

    public PlanManagementPage editPlanManagement() throws InterruptedException {
        this.scroll(3000);
        this.waitAndReturnElement(By.cssSelector("div[onclick='planManagement()']")).click();
        return new PlanManagementPage(driver,this);
    }

    public UserPage goMainUserPage(){
        this.scroll(-250);
        this.waitAndReturnElement(By.id("myProfileSection_nav")).click();
        return userPage;
    }

    @Override
    public Boolean openedCorrectly() throws InterruptedException {
        this.pageWait(4000);
        return this.getBodyText().contains("Nickname");
    }
}
