@Approver
Feature: Approver Testing .

  Scenario Outline: To verifying the Approver Login.
    Given Browser is open
    And User is on login page
    When user enter <username> and <password> and clicks on login
    And select the company and business_line
      | company    | business_line    |
      | Relo-India | NON RMC-BUSINESS |
    #| Relo-DUBAI     | RMC-BUSINESS     |
    #| Relo-BAHRAIN   |                  |
    #| Relo-QATAR     |                  |
    #| Relo-SINGAPORE |                  |
    #| RELO-KSA       |                  |
    And I click on submit button

    Examples: 
      | username | password |
      | Admin    |    93640 |

  Scenario Outline: To verifying the Quatation Approval.
    Given I am on the Pricing page
    And I click on the Menu
    And I click on the Pricing Button
    And I search the enquiry number
    And I click on Apply Estimate button
    And I clicks on apply quotation button

  And I click on the approval pending button
  And I click on Book button
  
    And I click on the billing and collection button
    And I select the Bill To on billing and collection page
      | BillTo |
      | Client |
    And I select the Payment type in details tab
      | Payment |
      | Full    |
    And I click and verify the save button
