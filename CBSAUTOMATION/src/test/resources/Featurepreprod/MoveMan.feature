@MoveMan
Feature: To verifying the job opening page\

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
      | shubham.shelkeIT |    29431 |

  Scenario: To verifying the job opening menu
    Given user is on the home page
    When user clicks on moveman
    And I click on open job menu
    And I search job by using enquiry number
      | Enquiry_Select |
      | Enquiry No     |
    And I click on open job or view job button
    And I selecting the Nationality
      | nationality |
      | INDIAN      |
    And I selecting origin warehouse
      | originWh             |
      | Panvel-Mumbai-Panvel |
    And I selecting destination warehouse
      | destWh               |
      | Panvel-Mumbai-Panvel |
    And I enter the advance payment details
      | Cheque_No |
      | Cash      |
    And I enter advanced amount
      | amount |
      |   2000 |
    And I selecting the HOSD
      | HOSD                |
      | CBS TESR USER 2-666873883 |
    And I selecting DestBrSD
      | BRSD                |
      | CBS TESR USER 2-666873883 |
    And I click on save job button

  #Feature:To verifying the Packing Stage Tab
  Scenario: To verifying the Packing Stage Tab
    Given I am on job opening page
    And I click on packing stage tab
    And I selecting the pack date
      | pack_date   |
      | 13-Sep-2024 |
    And I selecting the Load date
      | load_date   |
      | 15-Sep-2024 |
    And I selecting the Loose Cased from DropDown
      | losecased |
      | Loose     |
    And I selecting the LCL FCL
      | LCL_FCL |
      | LCL     |
    And I selecting the container size
      | container_Size |
      | 40ft (12.2m)   |
    And I selecting the volume unit
      | volume_unit |
      | CFT         |
    And I entered the net volume
      | netVolume |
      |       125 |
    And I entered the gross volume
      | gross_volume |
      |          140 |
    And I selecting Wt Unit
      | wt_unit |
      | LBS     |
    And I entered the wt_net volume
      | wt_net_volume |
      |           140 |
    And I entered the wt_gross volume
      | wt_gross_volume |
      |             150 |
    And I click on Get Cost button
    And I click on the packing cost
    And I selecting rate component
      | rate_component |
      | Origin         |
    And I selecting the cost head
      | selectingcostHead       |
      | PACKING/ORIGIN SERVICES |
    And I enter wt per unit
      | wt_per_unit |
      |           1 |
    And I enter the rate cost
      | rate |
      | 1000 |
    And I selecting the rate currency
      | currency |
      | INR      |
    And I enter the Revenue
      | Revenue |
      |    1500 |
    And I click on add button
    And I click on save paking button
