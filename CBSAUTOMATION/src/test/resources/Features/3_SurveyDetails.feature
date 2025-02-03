@SurveyDetails
Feature: Verify the Survey page functionality

  Scenario Outline: To verify the Survey page
    #Given Browser is open
    #And User is on login page
    #When user enter <username> and <password>
    #And user click on login
    #And select the company and business_line
    #Then user navigated to the home page
    And user clicks on the survey button
    And user is navigated to the survey page
    And user searches for an enquiry number
    And user clicks on the edit survey button

    Examples: 
      | username         | password |
      #| shubham.shelke |    26534 |
      | shubham.shelkeIT |    29431 |

  Scenario Outline: To verify the Survey detail tab
    And user clicks on the detail tab
    When user selects the Sch. Pack Date as "<sch_pack_date>"
    And user enters the number of days as "<no_of_days>"
    And user selects the Sch. Load Date as "<sch_load_date>"
    And user selects the Sch. Sub. Quote Date as "<sch_sub_quote_date>"
    And user selects the Req. Delivery Date as "<req_delivery_date>"
    And user selects the insurance provider as "<insurance_provider>"
    And user enters the Ins. Approx. Value as "<ins_approx_value>"
    And user selects the Ins. Currency as "<ins_currency>"

    Examples: 
      | sch_pack_date | no_of_days | sch_load_date | sch_sub_quote_date | req_delivery_date | insurance_provider | ins_approx_value | ins_currency |
      | 29-Jan-2025   |          2 | 30-JAN-2025   | 30-JAN-2025        | 30-JAN-2025       | Agent              |             4500 | INR          |

  Scenario Outline: To verify the Shipment detail tab on survey page
    And I fill the origin shipment details
    And I fill the destination shipment details

  Scenario Outline: Save shipment details only
    Then I save the shipment details
