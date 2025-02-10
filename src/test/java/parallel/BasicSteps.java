package parallel;

import Actions.BasicAction;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.testng.Assert.assertTrue;

public class BasicSteps {

    BasicAction ba = new BasicAction();

    @Given("I verify fr home page displays")
    public void iVerifyFrHomePageDisplays() {
        assertTrue(ba.verifyFRhomePageDisplays());
    }

    @Given("I click cartes american express")
    public void iClickCartesAmericanExpress() {
        assertTrue(ba.clickCartesAmericanExpressBtn());
    }


    @When("I verify cartes american express page and move to gold section")
    public void iVerifyCartesAmericanExpressPageAndMoveToGoldSection() {
        assertTrue(ba.verifyCartesAmericanExpress());
    }

    @Then("I click carte gold american express")
    public void iClickCarteGoldAmericanExpress() {
        assertTrue(ba.clickGoldExpressCard());
    }

    @And("I verify and click demandez vorte carte")
    public void iVerifyAndClickDemandezVorteCarte() {
        assertTrue(ba.verifyAndClickDemandezVorteCarte());
    }

    @And("I verify carte gold american express page")
    public void iVerifyCarteGoldAmericanExpressPage() {
        assertTrue(ba.verifyCarteGoldAmericanExpressPage());
    }

    @And("I enter the user value for gold carte")
    public void iEnterTheUserValueForGoldCarte() {
        assertTrue(ba.enterDetailsOnGoldCarte());
    }

    @When("I verify and enter value for info personal page")
    public void iVerifyAndEnterValueForInfoPersonalPage() {
        assertTrue(ba.veriftInfoPersonalPage());
    }

    @Then("I enter third level of validation")
    public void iEnterThirdLevelOfValidation() {
        assertTrue(ba.verifyEnterValueforThridLevel());
    }

    @And("I verify and enter security page")
    public void iVerifyAndEnterSecurityPage() {
        assertTrue(ba.verifyEnterValueforFourthLevel());
    }

    @And("I click the final page")
    public void iClickTheFinalPage() {
        assertTrue(ba.clickFinalButton());
    }
}
