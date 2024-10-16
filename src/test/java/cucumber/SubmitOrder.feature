@tag
Feature: Purchase the order from Ecommerce website
  I want to use this template for my feature file

  Background: 
    Given: I landed on Ecommerce Page


  @SubmitOrder01
  Scenario Outline: Positive Test of Submitting the order
    Given Logged in with username <name> and password <password>
    When I add the product <productName> to Card
    And Checkout <productName> and submit the order for <country>
    Then Verify "THANKYOU FOR THE ORDER." message is displayed on ConfirmationPage

    Examples: 
      | name                        | password       | productName | country	|
      | test@gmail.com | Password@1235 | ZARA COAT 3 | INDIA		|