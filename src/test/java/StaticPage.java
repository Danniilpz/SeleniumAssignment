import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class StaticPage extends BasePage{
    private String link;
    public StaticPage(ChromeDriver driver,String link) {
        super(driver);
        this.setLink(link);
    }
    public StaticPage(ChromeDriver driver) {
        super(driver);
        this.setLink("");
    }

    public Boolean openedCorrectly() throws InterruptedException {
        this.pageWait(1000);
        if(!link.equals("")){
            this.wait.until(ExpectedConditions.visibilityOfElementLocated(bodyLocator));
            return true;
        }
        else{
            return false;
        }
    }
    public String getLink() {
        return link;
    }
    public void setLink(String link) {
        this.link=link;
        if(!link.equals(""))
            this.driver.get(link);
    }
}
