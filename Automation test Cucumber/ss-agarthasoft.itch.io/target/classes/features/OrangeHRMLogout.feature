@Logout
Feature: Logout
I want to logout from http://qa.cilsy.id/

Background: User is logged in OrangeHRM
	Given User in login page OrangeHRM for Logout

@LogoutOrangeHRM
Scenario: User logout from OrangeHRM
	Given User in dashboard page
	When User click Logout url in username menu
	Then User successfully logout