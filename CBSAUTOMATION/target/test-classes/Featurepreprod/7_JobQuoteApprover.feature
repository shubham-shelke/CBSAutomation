@QuoteApprover
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

   Scenario: To verifying the job opening menu
    Given user is on the home page
    When user clicks on menu
    And I click on open job menu
    And I search job by using enquiry number
      | Enquiry_Select |
      | Enquiry No     |
    And I click on open job or view job button
		And I click on Delivery final stage tab
		And I click on pending button
	
	