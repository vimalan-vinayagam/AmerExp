package Tools;


import Utils.ObjectGenerator;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import static Tools.BaseClass.getObjectGenerator;

public class TextBox   {
    ObjectGenerator OG = getObjectGenerator();


    public  boolean enterValue(WebElement element, String strValue) {
        boolean isValueEntered = false;
        try {
            OG.sync.waitForSeconds(3000);
            if (element.isDisplayed()) {
                String NewTxt = strValue;
                String strOldText= OG.textBox.getText(element);
                if((strOldText == null) && (strOldText.isEmpty())){
                    element.sendKeys(Keys.chord(Keys.CONTROL,"a",Keys.DELETE));
                    element.sendKeys(strValue);
                }
                else if (NewTxt.equals(strOldText)){
                    System.out.println(NewTxt +" Already Value is entered");
                }
                else{
                    element.sendKeys(Keys.chord(Keys.CONTROL,"a",Keys.DELETE));
                    element.sendKeys(strValue);
                }
                isValueEntered = true;
            } else {
                System.out.println("Element not found to enter value");
            }
        } catch (Exception e) {

            System.out.println("Element not found" + e);
        }
        return isValueEntered;
    }


    public void verifyElement(WebElement element) {
        if (element.isDisplayed()) {
            System.out.println("Element found");
        } else {
            System.out.println("Element not found");

        }
    }


    public  String getText( WebElement element) {
        String strText ="";
        try {
            strText = element.getText();
        } catch (Exception e) {
            System.out.println("Text not found");
        }
        return strText;
    }

    public  void CompareText(WebElement element, String Str){

        if (element.isDisplayed()){
            String ST = getText(element);
            if (ST.equals(Str)){
                System.out.println(ST);
            }
        }
    }

}