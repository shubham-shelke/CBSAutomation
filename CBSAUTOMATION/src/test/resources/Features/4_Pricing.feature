@Pricing
Feature: Pricing Menu Interaction

  Scenario Outline: Click on the Pricing Menu
    Given I am on the Pricing page
    When I click on the Menu
    And I click on the Pricing Button
    And I search the enquiry number
    And I click on Apply Estimate button
    And I select rate component
    And I select agent
    And I select the cost head
      | costHead                      |
      | ADDITIONAL PROTECTIVE PACKING |
    And I enter the cost head amount
      | amount |
      |    500 |
    And I click on the Add button
    And I select freight rate component
    And I select the cost head
      | costHead                    |
      | Additional Freight Increase |
    And I enter the cost head amount
      | amount |
      |   1000 |
    And I click on the Add button
    And I select Destination rate component
    And I select the cost head
      | costHead        |
      | DESTINATION THC |
    And I enter the cost head amount
      | amount |
      |   1500 |
    And I click on the Add button
    And I click on save rates button
    And I clicks on apply quotation button
    And I enter the GP percentage in GP text box
      | percentage |
      |         30 |
    And I click on the Apply to All button
    And I click on save button
    And I click on the send for Approval button
    And I select the approver
      | Approver_List        |
      | Ananthan S ..-000001 |
    And I click on proceed for approval button
