import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {
    protected ChromeDriver driver;
    protected WebDriverWait wait;
    protected final By bodyLocator=By.tagName("body");

    public BasePage(ChromeDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
    }

    public WebElement waitAndReturnElement(By locator) {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return this.driver.findElement(locator);
    }
    public String getBodyText(){
        WebElement e=this.waitAndReturnElement(bodyLocator);
        return e.getText();
    }
    public void pageWait(long millis) throws InterruptedException {
        Thread.sleep(millis);
    }
    public void scroll(int n){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("scroll(0, "+n+");");
    }
    public void goBack(){
        driver.navigate().back();
    }
    abstract public Boolean openedCorrectly() throws InterruptedException;

}
