package Tools;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static Tools.BaseClass.getDriver;

public class Sync   {
    WebDriverWait wait;

    public Sync(){
        this.wait = new WebDriverWait(getDriver(), Duration.ofSeconds(20));
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

    public void waitForElementToVisible(WebElement element){
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForElementToVisibleClickable(WebElement element){
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }




}
