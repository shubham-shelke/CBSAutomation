#Author:
@Login
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
    #| Relo-SINGAPORE | NON RMC-BUSINESS |
    #| RELO-KSA       |                  |
    And I click on submit button
    Then user navigated to the home page

    Examples: 
      | username         | password |
      #| shubham.shelke |    26534 |
      #| shubham.shelkeIT |    29431 |
      | CBSTEST2       |    28221 |
      #| Admin          |    93640 |
