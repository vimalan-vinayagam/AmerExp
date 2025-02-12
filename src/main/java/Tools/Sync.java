package Tools;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;
public class Sync extends BaseClass   {
    WebDriverWait wait;

    public Sync(){
        this.wait = new WebDriverWait(Driver.get(), Duration.ofSeconds(10));
    }
    public  void waitForSeconds(int lngSeconds) {
        try {
            Thread.sleep( lngSeconds);

        } catch (Exception e) {
            System.out.println("Static wait "+e);
        }
    }

    public  void ImplicityWait(WebDriver driver,long lngSeconds){

        try {
            driver.manage().timeouts().implicitlyWait(lngSeconds, TimeUnit.SECONDS);
        }
        catch (Exception e){
            System.out.println("Dynamic wait "+e);
        }

    }

    public WebElement waitForElementToVisible(WebElement element){
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public WebElement waitForElementToVisibleClickable(WebElement element){
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }




}
