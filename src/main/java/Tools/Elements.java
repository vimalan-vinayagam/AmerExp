package Tools;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;

import java.util.logging.Logger;
public class Elements {

    Logger log = Logger.getLogger(Elements.class.getName());

    public  void click(WebElement element) {
        try {
            element.click();
        } catch (Exception e) {
            log.info("Click is failed " + e);
        }
    }

    public  void pageUp(WebDriver driver) {
        Actions action = new Actions(driver);
        action.sendKeys(Keys.HOME).build().perform();
    }

    public  boolean scrollToElement(WebDriver driver,WebElement element) {
        boolean isScrollToView = false;
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView();", element);
            isScrollToView = true;

        } catch (Exception e) {
            log.info("Element not found to scroll  " + e);
        }
        System.out.println("scrollToElement bool value is"+isScrollToView);
        return isScrollToView;
    }




}
