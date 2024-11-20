Feature: Login related scenarios

  Background:
    #Given user is able to access HRMS application

   @sprint1
  Scenario: valid admin login
    When user enters valid username and password
    And user clicks on login button
    Then  user is navigated to dashbaord page


      @error @sora
     Scenario: Invalid admin login
       #Given user is able to access HRMS application
       When user enters invalid username and password
       And user clicks on login button
       Then  user can see error message