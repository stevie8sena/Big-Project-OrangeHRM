@AddEmployee
Feature: I want to add Employee

Background: User is logged in OrangeHRM
	Given User in login page OrangeHRM for Add Employee

@PositiveAdd
Scenario Template: Add employee using valid data
	Given User on add employee page
	When Input data using "Rasyid" as firstname, "Sholeh" as middlename, "Rosena" as lastname and <randomnumber> as employeeid
	
Scenarios: 
   | randomnumber |
   |  |