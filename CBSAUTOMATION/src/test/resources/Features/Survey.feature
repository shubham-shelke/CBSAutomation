Feature: Verify the Survey page functionality

  Scenario Outline: To verify the Survey page
    Given Browser is open
    And User is on login page
    When user enter <username> and <password>
    And user click on login
    And select the company and business_line
    Then user navigated to the home page
    #And user is on the home page
    And user clicks on the survey button
    And user is navigated to the survey page
    And user searches for an enquiry number
    And user clicks on the edit survey button
    And user clicks on the detail tab
		And user verifies the surveyed Date
    #And user verifies the time
    #And user verifies the survey conducted by
    #And user selects the Sch. Pack Date
    #And user enters the number of days required for loading
    #And user selects the Sch. Load Date
    #And user selects the Sch. Sub. Quote Date
    #And user selects the Req. Delivery Date
    #And user selects the insurance provider
    #And user enters the Ins. Approx. Value
    #And user selects the Ins. Currency
    #
    #Examples:
    #| enquiry_number | surveyed_date | time  | survey_conducted_by | sch_pack_date | no_of_days | sch_load_date | sch_sub_quote_date | req_delivery_date | insurance_provider | ins_approx_value | ins_currency |
    #| MUML112233     | 14-Aug-2024   | 16:07 | Shubham Shelke-2222 | 15-Aug-2024   |          3 | 18-Aug-2024   | 16-Aug-2024        | 16-Aug-2024       | Agent              |             2000 | INR          |
    Examples: 
      | username       | password |
      #| shubham.shelke |    26534 |
      | shubham.shelkeIT |    29431 |
