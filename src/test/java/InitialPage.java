import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class InitialPage extends BasePage{
    public InitialPage(ChromeDriver driver){
        super(driver);
    }

    @Override
    public Boolean openedCorrectly() throws InterruptedException {
        this.pageWait(1000);
        return this.getBodyText().contains("Mejora tus notas con Wuolah.");
    }

    public void open() throws InterruptedException {
        this.driver.get("https://www.wuolah.com/");
        if(driver.findElements(By.cssSelector("button[aria-label='Aceptar']")).size() != 0)
            this.waitAndReturnElement(By.cssSelector("button[aria-label='Aceptar']")).click();
        this.pageWait(2000);
    }
    public LoginPage login(){
        this.waitAndReturnElement(By.xpath("//*[@id='desktop_layout']/nav/div[2]/div/button[2]")).click();
        return new LoginPage(driver);
    }
}
