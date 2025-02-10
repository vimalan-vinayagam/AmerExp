package Tools;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import java.util.List;
public class DropDown {

    public  void selectByText(WebElement element, String strText) {
        if (element.isDisplayed()) {
            Select Sel = new Select(element);
            Sel.selectByVisibleText(strText);
        } else {
            System.out.println("Text not selected");
        }
    }


    public void selectByOption(WebElement element, String str) {
            Select select = new Select(element);
            List<WebElement> options = select.getOptions();

            for (WebElement option : options) {
                if (option.getText().contains(str)) {
                    option.click();
                    break;
                }
            }
    }


}
