@Skip
Feature: AmerExpCard

  Background:
    Given I verify fr home page displays

  Scenario: User created a sample express card level one
    Given I click cartes american express
    When I verify cartes american express page and move to gold section
    Then I click carte gold american express
    And I verify and click demandez vorte carte
    And I verify carte gold american express page
    And I enter the user value for gold carte
    When I verify and enter value for info personal page
    Then I enter third level of validation
    And I verify and enter security page
    And I click the final page
