@AssignLeave
Feature: I want to assign leave employee

Background: User is logged in OrangeHRM
	Given User in login page OrangeHRM for Assign Leave

@AssignLeaveNegative
Scenario: Assign Leave using invalid data
	Given User on Assign Leave page
	When Leave all field empty
	Then Leave not added

@AssignLeavePositive
Scenario: Assign Leave using valid data
	Given User on Assign Leave page
	When User fill employee name, leave type, and date
	Then Employee leave added on list