@tag
 Feature: Error Validation
 
 @tag2
 Scenario Outline:Negative Test Checking LoginValidation
 Give I landed on Ecommerce Page
 When Logged in with Username <name> and password <password>
 Then "Incorrect email or password" message is displayed
 
 Examples:
      | name                | password
      |aniltc1999@gmail.com |Kumar@1147