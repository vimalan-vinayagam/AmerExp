package Tools;


import org.openqa.selenium.WebDriver;
import java.util.concurrent.TimeUnit;
public class Sync    {

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




}
