@Login
Feature: Login
I want to login to http://qa.cilsy.id/

@PositiveLogin
Scenario: User login using valid credentials
	Given User in OrangeHRM login page
	When Input authentication using "Admin" as username and "s3Kol4HQA!*" as password
	Then User navigate to OrangeHRM dashboard

@NegativeLogin
Scenario Template: User login using invalid credentials
	Given User in OrangeHRM login page
	When Input invalid authentication using <uname> as username and <pw> as password
	Then Error message <result>
	
Scenarios: 
   | uname | pw		 			  | result		 							  |
   | admin | s3Kol4HQA!*. | Invalid credentials		 		|
   | Admin | 						  | Password cannot be empty	|
   | 			 | s3Kol4HQA!*  | Username cannot be empty	|