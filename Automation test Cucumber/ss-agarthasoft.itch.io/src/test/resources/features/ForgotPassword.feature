@ForgotPass
Feature: Forgot Password

@ForgotPass
Scenario: User is Forgot Password
	Given User navigate to Forgot Password page from OrangeHRM login page
	When User input "Admin" as username
	Then Instruction for reset password has sent