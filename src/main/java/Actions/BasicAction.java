package Actions;

import OR.BasicUI;
import Tools.BaseClass;
import Utils.ObjectGenerator;
import Utils.PropertyReader;
import org.openqa.selenium.WebDriver;

import static Tools.BaseClass.getDriver;



public class BasicAction extends BasicUI {
    protected WebDriver driver;
    protected ObjectGenerator OG;

    public BasicAction() {
        this.driver = getDriver(); // Get driver from BaseClass
        this.OG = BaseClass.getObjectGenerator(); // Ensure thread safety
        OG.initPage(); // Initialize page objects
    }

    public boolean verifyFRhomePageDisplays() {
        boolean IsVerified = true;
        OG.sync.waitForElementToVisible(BtnRejectAlert);
        if (BtnRejectAlert.isDisplayed()){
            BtnRejectAlert.click();
        }
        OG.textBox.verifyElement(FRhomeLable);
        return IsVerified;
    }

    public boolean clickCartesAmericanExpressBtn() {
        boolean IsClicked = true;
        try {
            if (BtnCartesAmericanExpress.isDisplayed()) {
                OG.ele.click(BtnCartesAmericanExpress);
            }
            OG.sync.ImplicityWait(driver,5);
            return IsClicked;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean verifyCartesAmericanExpress(){
        boolean IsVerify = true;
        OG.sync.waitForElementToVisible(BtnRejectAlert);
        if (BtnRejectAlert.isDisplayed()){
            BtnRejectAlert.click();
        }
        OG.ele.scrollToElement(driver,LblCartesAmericanExp);
        OG.textBox.verifyElement(LblCartesAmericanExp);

        return IsVerify;
    }
    public boolean clickGoldExpressCard(){
        boolean IsClicked = true;
        OG.ele.scrollToElement(driver,LblGanezDes);
        if (BtnGoldCred.isDisplayed()){
            BtnGoldCred.click();
            return IsClicked;
        }
        return false;
    }

    public boolean verifyAndClickDemandezVorteCarte(){
        boolean IsVerify = true;
        OG.textBox.verifyElement(LblGoldCarteExpressPage);
        if (BtnDemandezVorteCarte.isDisplayed()){
            BtnDemandezVorteCarte.click();
            return IsVerify;
        }else {
            return false;
        }
    }

    public boolean verifyCarteGoldAmericanExpressPage() {
        boolean IsVerified = true;
        OG.textBox.verifyElement(LblGoldExpressCarte);
        return IsVerified;
    }

    public boolean enterDetailsOnGoldCarte(){
        boolean IsEnter = true;

        if (BtnRadMrTag.isDisplayed()){
            BtnRadMrTag.click();
            OG.textBox.enterValue(TxtBoxPrenom, PropertyReader.getProperty("prename"));
            OG.textBox.enterValue(TxtBoxNom, PropertyReader.getProperty("secondname"));
            OG.textBox.enterValue(TxtBoxDateDeNaissance, PropertyReader.getProperty("dob"));
            OG.ele.scrollToElement(driver,TxtBoxTelephone);
            OG.textBox.enterValue(TxtBoxEmail, PropertyReader.getProperty("email"));
            OG.dd.selectByText(DpdnCountryCode,PropertyReader.getProperty("countrycode"));
            OG.textBox.enterValue(TxtBoxTelephone,PropertyReader.getProperty("phonenum"));
            BtnSauvegarder.click();
            return IsEnter;
        }
        else {
        return false;
        }

    }

    public boolean veriftInfoPersonalPage(){
        boolean IsVerified = true;
        OG.ele.pageUp(driver);
        OG.textBox.verifyElement(LblInfoPer);
        if (LblNamDe.isDisplayed()){
            LblNamDe.click();
            if (TxtBoxBirthName.isDisplayed()){
                OG.textBox.CompareText(TxtBoxBirthName,PropertyReader.getProperty("secondname"));
            }
            OG.textBox.enterValue(TxtBoxLieuDeNai,PropertyReader.getProperty("random"));
            OG.dd.selectByOption(DpdnDeptBirth,PropertyReader.getProperty("dropdown"));
            OG.textBox.enterValue(TxtBoxNType,PropertyReader.getProperty("random"));
            OG.textBox.enterValue(TxtBoxPostCode,PropertyReader.getProperty("postcode"));
            OG.textBox.enterValue(TxtBoxCityCode,PropertyReader.getProperty("random"));
            OG.ele.scrollToElement(driver,DpdnResStatua);
            OG.dd.selectByText(DpdnResStatua,PropertyReader.getProperty("resstatus"));
            BtnSauvegarder.click();
            return  IsVerified;
        }else {
            return false;
        }
    }

    public boolean verifyEnterValueforThridLevel(){
        boolean IsVerified = true;
        if (LblFinance.isDisplayed()){
            OG.textBox.enterValue(TxtBoxIban,PropertyReader.getProperty("iban"));
            OG.textBox.enterValue(TxtBoxSwiftCode,PropertyReader.getProperty("swiftcode"));
            OG.ele.scrollToElement(driver,DpdnYears);
            OG.dd.selectByText(DpdnYears,PropertyReader.getProperty("years"));
            OG.textBox.enterValue(TxtBoxIncome,PropertyReader.getProperty("income"));
            RdoBtnNo.click();
            OG.ele.scrollToElement(driver,RdoBtnNo);
            OG.dd.selectByOption(DpdnAnnualIncome,PropertyReader.getProperty("annualinc"));
            OG.dd.selectByText(DpdnStatus,PropertyReader.getProperty("status"));
            OG.ele.scrollToElement(driver,DpdnStatus);
            OG.dd.selectByText(DpdnVoteProf,PropertyReader.getProperty("vote"));
            BtnSauvegarder.click();
            return  IsVerified;
        }else {
            return false;
        }

    }

    public boolean verifyEnterValueforFourthLevel(){
        boolean IsVerified = true;
        if (LblSecutiryInfo.isDisplayed()){
            OG.textBox.enterValue(TxtBoxMotherMaiden,PropertyReader.getProperty("random"));
            OG.textBox.enterValue(TxtBoxPin,PropertyReader.getProperty("pin"));
            OG.ele.scrollToElement(driver,TxtBoxConfirmPin);
            OG.textBox.enterValue(TxtBoxConfirmPin,PropertyReader.getProperty("pin"));
            OG.ele.scrollToElement(driver,RdoBtnYesEmail);
            OG.sync.waitForSeconds(4000);
            RdoBtnYesEmail.click();
            OG.sync.waitForSeconds(4000);
            RdoBtnYesSMS.click();
            BtnSumbit.click();
            return  IsVerified;
        }else {
            return false;
        }

    }

    public boolean clickFinalButton() {
        boolean IsClicked = true;
        OG.sync.ImplicityWait(driver,20);
        OG.ele.pageUp(driver);
        BtnFinal.click();
        OG.textBox.verifyElement(FRhomeLable);
        return IsClicked;
    }

}
