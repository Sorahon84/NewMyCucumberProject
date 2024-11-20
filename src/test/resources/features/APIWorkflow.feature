Feature: API workflow

  Background:
    Given a JWT bearer token is generated

  @api
  Scenario: create employee
    Given a request is prepared for creating the employee
    When a POST call is made to create the employee
    Then the status code for this request is 201
    Then the employee id "Employee.employee_id" is stored and values are validated


  @api
  Scenario: Get the created employee
    Given a request is prepared to get the created employee
    When a GET call is made to get the created employee
    Then the status for for get call is 200
    And the employee has same employee id "employee.employee_id" as global empid
    And the data coming from the get call should equal to the data used in POST call
      |emp_firstname|emp_lastname|emp_middle_name|emp_gender|emp_birthday|emp_status|emp_job_title|
      |asana        |lawrance    |ms             |Female    |1993-01-12  |permanent |QA manager   |
@json
    Scenario: create employee using json payload
      Given  a request is prepared for creating the employee using json payload
      When a POST call is made to create the employee
      Then the status code for this request is 201
      Then the employee id "Employee.employee_id" is stored and values are validated

  @dynamic
  Scenario: Create employee using more dynamic json payload
    Given a request is prepared using data "asana" , "lawrance","ms","F", "1993-12-01","permanent","QA Manager"
    When a POST call is made to create the employee
    Then the status code for this request is 201
    Then the employee id "Employee.employee_id" is stored and values are validated



  @api1
  Scenario: Update the created employee details
    Given a request is prepared to update the employee details with payload
    When a PUT call is made to update the employee
    Then the status for for update employee 200
    Then update employee id "Employee.employee_id" is stored and values are validated

  @api1
  Scenario: Get the updated employee
    Given a request is prepared to get the updated employee
    When a GET call is made to get the updated employee
    Then the status for get update call is 200
    And the employee has same  with update "employee.employee_id" as global empid
    And the data coming from the put  call should equal to the updated data
      |emp_firstname|emp_lastname|emp_middle_name|emp_gender|emp_birthday|emp_status |emp_job_title|
      |denis        |sekar       |msa            |Male      |2020-11-07  |Probation |Trainee      |



  @api2
  Scenario: Partially update an employee's details using a PATCH request
    Given an existing employee ID "113772A" is set
    And a request is prepared to patch the employee details
    When a PATCH call is made to update partial details of the employee
    Then the status code for the PATCH call is 201
    And the employee details should reflect the partial updates

  @api2
  Scenario: Get the details of the patched employee
    Given an existing employee ID "113772A" is set
    And a request is prepared to get the patched employee details
    When a GET call is made to retrieve the patched employee details
    Then the status code for the GET call is 200
    And the employee details should match the patched updates
















