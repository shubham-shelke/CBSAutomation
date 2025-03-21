#Author:
#@Enquiry
#Feature: Test Enquiry creation
#
  #Scenario Outline: Check the Enquiry form field with valid data
    #Given user is on the home page
    #When user click on the Enquiry button
    #Then Enquiry page should be open
    #And user clicks on the create button
    #And user selecting the <revenue_branch>
    #And user selecting the <move_class>
    #And user selecting the <info_source>
    #And user enter the enquiry form <name>
    #And user select the tentive movedate
    #And user select the enquiry receiveddate
    #And user selecting the <client>
    #And user selecting the <corporate>
    #And user selecting the <account_manager>
    #And user select the shipper <title>
    #And user selects the shipper <designation>
    #And user selects the shipper type <shipper_type>
    #And user selects the shipment category <ship_category>
    #And user selects the shipper city <city>
    #And user selects the shipper nationality <nationality>
#
    #Examples: 
      #| revenue_branch | move_class | info_source | name | client | corporate | account_manager     | title | designation | shipper_type | ship_category | address1 | address2 | city                     | nationality |
      #| MUMBAI         | Quote      | WhatsApp    | Test | CARTUS | Aargus    | Shubham Shelke-2222 | Mr.   | CEO         | Government   | VIP           | Lalbaug  | Mumbai   | MUMBAI-Maharashtra-INDIA | INDIAN      |
#
  #Scenario Outline: Verifying <field> text box
    #And user enter the shipper <field> as "<value>"
#
    #Examples: 
      #| field         | value                                |
      #| first_name    | Testing                              |
      #| last_name     | Automation                           |
      #| address1      | PN Writer HO                         |
      #| address2      | Lalbaug                              |
      #| pincode       |                               400012 |
      #| mobile_number |                           9168534744 |
      #| email         | shubham.shelke@writerrelocations.com |
#
  #Scenario Outline: To verify dropdowns present on the detailed tab
    #And user clicks on the detailed tab
    #And user select the shipment <field> as "<value>"
#
    #Examples: 
      #| field           | value           |
      #| handling_branch | MUMBAI          |
      #| service_line    | DOMESTIC        |
      #| transit_mode    | Road            |
      #| shipment Type   | Door To Door    |
      #| commodity       | HOUSEHOLD GOODS |
#
  #Scenario Outline: To verify tentive move date on the detailed tab
    #And user selects the tentive move date
#
  #Scenario Outline: User selects cities from Origin and Destination dropdowns
    #And the user selecting the origin city
    #And the user selecting destination city
    #And the clicks on the SchSurvey Details tab
    #And user selecting Sch.Surveyor Name
    #And user selecting Sch.Survey Type
    #And user selecting Sch Survey Date
    #And click on add shipment button
    #And click on save button
