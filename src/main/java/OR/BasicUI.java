package OR;

import Tools.BaseClass;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import static Tools.BaseClass.getDriver;

public class BasicUI {

    public BasicUI()
    {
        PageFactory.initElements(getDriver(), this);
    }

    @FindBy(how = How.XPATH,using = "//button[.='Tout Refuser']")
    public WebElement BtnRejectAlert;

    @FindBy(how = How.XPATH,using = "//span[@class='axp-global-header__GlobalHeader__centeredLogoFoc___1f3tY axp-global-header__dls-module__dlsLogoBlueboxSolidSm___13LtE axp-global-header__GlobalHeader__media_width_low___1WXb4']")
    public WebElement FRhomeLable;

    @FindBy(how = How.XPATH,using = "//p[text()='Cartes American Express®']")
    public WebElement BtnCartesAmericanExpress;


    @FindBy(how = How.XPATH,using = "//a[@id='LesCartesAmericanExpress']")
    public WebElement LblCartesAmericanExp;

    @FindBy(how = How.XPATH,using = "//li[contains(.,'Gagnez des points de fidélité à chaque achat')]")
    public WebElement LblGanezDes;

    @FindBy(how = How.XPATH,using = "//a[@href='https://www.americanexpress.com/fr/carte-de-paiement/gold-card-americanexpress/?intlink=fr-proprietary-gold']")
    public WebElement BtnGoldCred;

    @FindBy(how = How.XPATH,using = "//h1[@class='sc_padding_none sc_margin_none sc_color_black sc_textBody_4 sc_paddingBottom_20']")
    public WebElement LblGoldCarteExpressPage;

    @FindBy(how = How.XPATH,using = "//a[@href='https://www.americanexpress.com/fr/3534?intlink=fr-amex-cardshop-details-apply-GoldCardAmericanExpress-siderail']")
    public WebElement BtnDemandezVorteCarte;

    @FindBy(how = How.XPATH,using = "//h3[.='CARTE GOLD AMERICAN EXPRESS']")
    public WebElement LblGoldExpressCarte;

    @FindBy(how = How.XPATH,using = "//label[@for='MR']")
    public WebElement BtnRadMrTag;

    @FindBy(how = How.XPATH,using = "//input[@id='fieldControl-input-firstName']")
    public WebElement TxtBoxPrenom;

    @FindBy(how = How.XPATH,using = "//input[@id='fieldControl-input-lastName']")
    public WebElement TxtBoxNom;

    @FindBy(how = How.XPATH,using = "//input[@id='fieldControl-input-dateOfBirth']")
    public WebElement TxtBoxDateDeNaissance;

    @FindBy(how = How.XPATH,using = "//input[@id='fieldControl-input-email']")
    public WebElement TxtBoxEmail;

    @FindBy(how = How.XPATH,using = "//select[@id='countryCode']")
    public WebElement DpdnCountryCode;

    @FindBy(how = How.XPATH,using = "//select[@id='countryCode']//option[.]")
    public WebElement DpdnCountryCodeValue;

    @FindBy(how = How.XPATH,using = "//input[@id='fieldControl-input-mobilePhoneNumber']")
    public WebElement TxtBoxTelephone;

    @FindBy(how = How.XPATH,using = "//button[.='Sauvegarder et Continuer']")
    public WebElement BtnSauvegarder;

    @FindBy(how = How.XPATH,using = "//h2[.='Vos informations personnelles']")
    public WebElement LblInfoPer;

    @FindBy(how = How.XPATH,using = "//label[@class='css-qv4r03']")
    public WebElement LblNamDe;

    @FindBy(how = How.XPATH,using = "//input[@id='birthName']")
    public WebElement TxtBoxBirthName;

    @FindBy(how = How.XPATH,using = "//input[@id='fieldControl-input-placeOfBirth']")
    public WebElement TxtBoxLieuDeNai;

    @FindBy(how = How.XPATH,using = "//select[@id='fieldControl-input-departmentOfBirth']")
    public WebElement DpdnDeptBirth;

    @FindBy(how = How.XPATH,using = "//input[@id='fieldControl-input-residentialAddressLine2']")
    public WebElement TxtBoxNType;

    @FindBy(how = How.XPATH,using = "//input[@id='fieldControl-input-postcode']")
    public WebElement TxtBoxPostCode;

    @FindBy(how = How.XPATH,using = "//input[@id='fieldControl-input-cityTown']")
    public WebElement TxtBoxCityCode;

    @FindBy(how = How.XPATH,using = "//select[@id='fieldControl-input-personalResidentialStatus']")
    public WebElement DpdnResStatua;

    @FindBy(how = How.XPATH,using = "//h2[.='Vos informations financières']")
    public WebElement LblFinance;

    @FindBy(how = How.XPATH,using = "//input[@id='fieldControl-input-bankAccountNumber']")
    public WebElement TxtBoxIban;

    @FindBy(how = How.XPATH,using = "//input[@id='fieldControl-input-bankIdentifierCode']")
    public WebElement TxtBoxSwiftCode;

    @FindBy(how = How.XPATH,using = "//select[@id='fieldControl-input-tenureOfAccount']")
    public WebElement DpdnYears;

    @FindBy(how = How.XPATH,using = "//input[@id='fieldControl-input-annualPersonalIncome']")
    public WebElement TxtBoxIncome;

    @FindBy(how = How.XPATH,using = "//label[@for='hasAdditionalIncome1-NO']")
    public WebElement RdoBtnNo;

    @FindBy(how = How.XPATH,using = "//select[@id='fieldControl-input-totalAssets']")
    public WebElement DpdnAnnualIncome;

    @FindBy(how = How.XPATH,using = "//select[@id='fieldControl-input-occupation']")
    public WebElement DpdnStatus;

    @FindBy(how = How.XPATH,using = "//select[@id='fieldControl-input-occupationDescription']")
    public WebElement DpdnVoteProf;

    @FindBy(how = How.XPATH,using = "//h2[.='Vos informations de sécurité']")
    public WebElement LblSecutiryInfo;

    @FindBy(how = How.XPATH,using = "//input[@id='fieldControl-input-mothersMaidenName']")
    public WebElement TxtBoxMotherMaiden;

    @FindBy(how = How.XPATH,using = "//input[@id='fieldControl-input-pin']")
    public WebElement TxtBoxPin;

    @FindBy(how = How.XPATH,using = "//input[@id='fieldControl-input-confirmPin']")
    public WebElement TxtBoxConfirmPin;

    @FindBy(how = How.XPATH,using = "//label[@for='marketingEmailPreferences-true']")
    public WebElement RdoBtnYesEmail;

    @FindBy(how = How.XPATH,using = "//label[@for='marketingSMSPhonePostalPreferences-OPT_IN']")
    public WebElement RdoBtnYesSMS;

    @FindBy(how = How.XPATH,using = "//button[@class='css-19hct2l']")
    public WebElement BtnSumbit;

    @FindBy(how = How.XPATH,using = "//button[@class='btn btn-primary css-19hct2l']")
    public WebElement BtnFinal;


}
