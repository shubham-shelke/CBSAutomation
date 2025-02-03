#Author:
#@Login
@Billing
Feature: Test User login Functionality

  Scenario Outline: Check Login is successful with valid credentials
    Given Browser is open
    And User is on login page
    When user enter <username> and <password> and clicks on login
    And select the company and business_line
      | company    | business_line    |
      | Relo-India | NON RMC-BUSINESS |
    #| Relo-India | RMC-BUSINESS  |
    #| Relo-DUBAI     | RMC-BUSINESS     |
    #| Relo-BAHRAIN   |                  |
    #| Relo-QATAR     |                  |
    #| Relo-SINGAPORE |                  |
    #| RELO-KSA       |                  |
    And I click on submit button
    Then user navigated to the home page

    Examples: 
      | username       | password |
      #| shubham.shelke |    26534 |
      | shubham.shelkeIT |    29431 |

  #| CBSTEST2       |    28221 |
  #| Admin          |    93640 |
  Scenario Outline: preparing the bill
    Given user is on the home page
    When user clicks on menu
    And I click on open job menu
    And I search job by using enquiry number
      | Enquiry_Select |
      | Enquiry No     |
    And I click on open job or view job button
		And I click on Delivery final stage tab
    And I click on Delivey Cost button
		And I selecting the cost heads 
		And I click on the prepare bill button
    And click on the prepareBill button
    And select the Bill TO
      | Bill_TO |
      | Shipper |
		And click on the get tax button
		