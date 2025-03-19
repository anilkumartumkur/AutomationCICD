@tag
 Feature: Purchase the order from Ecommerce Website
 I want to use this template for my feature file
 
 Background:
 Give I landed on Ecommerce Page
 
 @Regression
 Scenario Outline:Positive Test of Submitting the Order
 Give Logged in with Username <name> and password <password>
 When I add product <productname> from Cart
 And Checkout <productname> and <name> submit the order
 Then "THANKYOU FOR THE ORDER." message is displayed output
 
 Examples:
      | name                | password   |productname  
      |aniltc1999@gmail.com |Kumar@1146  |ZARA COAT 3    