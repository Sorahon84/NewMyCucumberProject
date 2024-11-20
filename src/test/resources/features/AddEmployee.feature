Feature: Add employee

  Background:
   # Given user is able to access HRMS application
    When user enters valid username and password
    And user clicks on login button
    Then  user is navigated to dashbaord page
    When user clicks on PIM option
    And user clicks on add employee option

  @sprint1 @melissa
  Scenario: Adding the employee by firstname and lastname
    And user enters firstname and lastname
    And user clicks on save button
    Then employee added successfully

  @sprint2 @smoke @regression @melissa
  Scenario: Adding the employee by firstname middlemen and lastname
    And user enters firstname and middleman and lastname
    And user clicks on save button
    Then employee added successfully

  @params
  Scenario: Adding employee using parameters
    And user enters "Mark" and "Anthony" and "Jacob"  in the application
    And user clicks on save button
    Then employee added successfully
@example
  Scenario Outline: Adding multiple employees
    And user add "<firstName>","<middleName>" and "<lastName>"
    And user clicks on save button
    Then employee added successfully
    Examples:
      | firstName | middleName | lastName |
      | Mark      | MS         | Jacob    |
      | Adam      | MS         | Jacob    |
      | Steve     | MS         | Jacob    |

@data
  Scenario: Adding multiple employees using data table
    When user adds multiple employees using data table and save them
    |firstName  | middleName |lastName  |
    | Mark      | MS         | Jacob    |
    | Adam      | MS         | Jacob    |
    | Steve     | MS         | Jacob    |

  @excel
Scenario:  Adding employees using excel file
  When user adds multiple employees from excel file
