Feature: Testing Login functionality
Scenario: User login using valid credentials
Given User should be on login page
When user enters correct username password
Then Display AccountSummary Page
And displays log out link on that page

Scenario: user logins using invalid credentials
Given User should be on login page
When User enters in valid username password
Then Dispay Error message 'Invalid Details'

Scenario: User Logins using emty credentials
Given User should be on login page
When User keeps username password blank
Then Display Error message 'Please Enter Credentials'