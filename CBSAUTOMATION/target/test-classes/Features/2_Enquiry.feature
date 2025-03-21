#Author:
@Enquiry
Feature: Test Enquiry creation

  Scenario: Check the Enquiry form field with valid data
    Given user is on the home page
    When user click on the Enquiry button
    Then Enquiry page should be open
    And user clicks on the create button
    And user selecting the revenue_branch
      | revenue_branch |
      | MUMBAI         |
    And user selecting the move_class
      | move_class |
      | Quote      |
    And user selecting the info_source
      | info_source |
      | WhatsApp    |
    And user enter the enquiry form name
      | name            |
      | Automation_Test |
    And user select the tentive movedate
    And user select the enquiry receiveddate
    And user selecting the client
      | client |
      | Cartus |
    #| Writer |
    And user selecting the corporate
      | corporate |
      | Aargus    |
    And user selecting the account_manager
      | account_manager     |
      | Shubham Shelke-2222 |
    And user select the shipper title
      | title |
      | Mr.   |
    And user enters the shipper first name
      | first_name |
      | Shubham    |
    And User enters the shipper last name
      | last_name |
      | Test      |
    And user selects the shipper designation
      | designation |
      | CEO         |
    And user selects the shipper type shipper_type
      | shipper_type |
      | Government   |
    And user selects the shipment category ship_category
      | ship_category |
      | VIP           |
    And user fills the address1
      | address1           |
      | Writer_relocations |
    And user fills the address2
      | address2 |
      | Lalbaug  |
    And user selects the shipper city city
      | city                     |
      | MUMBAI-Maharashtra-INDIA |
    And User Enters the Pincode
      | pincode |
      |  411005 |
    And user selects the shipper nationality nationality
      | nationality |
      | INDIAN      |
    And user enters the mobile number
      | mobile_number |
      |    9168534744 |
    And user enters the email address
      | email                                |
      | shubham.shelke@writerrelocations.com |
    #Scenario: To verify dropdowns present on the detailed tab
    And user clicks on the detailed tab
    And user select the handling branch
      | handling_branch |
      | MUMBAI          |
    And user select the service_line
      | service_line |
      | DOMESTIC     |
      #| DMMS         |
    #| EXPORT-Local |
    And user select the transit mode
      | transit_mode |
      | Road         |
    #| Air          |
    And user select the handling shipment type
      | shipment_Type |
      | Door To Door  |
    And user select the commodity
      | commodity       |
      | HOUSEHOLD GOODS |
    And user selects the tentive move date
    #Scenario: User selects cities from Origin and Destination dropdowns
    And the user selecting the origin city
      | originCity                      |
      | CITY BANGALORE -Karnataka-INDIA |
    #| MUMBAI-Maharashtra-INDIA |
    And the user selecting destination city
      | destinationCity          |
      #| CITY BANGALORE -Karnataka-INDIA |
      | MUMBAI-Maharashtra-INDIA |
    #| BERLIN-BERLIN-GERMANY |
    And the clicks on the SchSurvey Details tab
    And user selecting Sch.Surveyor Name
      | surveyor_name            |
      #| Shubham Shelke-2222 |
      | Shubham Shelke IT-058571 |
    And user selecting Sch.Survey Type
      | survey_Type |
      | Virtual     |
    And user selecting Sch Survey Date
    And click on add shipment button
    And click on save button
