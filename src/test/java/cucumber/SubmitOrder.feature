Feature: Purchase the order from Ecommerce website
  # Brief description of what this feature covers
  I want to use this template for my feature file

  # Background step that will run before each scenario in this feature
  Background: 
    # Step to navigate to the Ecommerce page before test execution
    Given: I landed on Ecommerce Page

  # Tag specific to this scenario for filtering or reporting purposes
  @SubmitOrder01
  Scenario Outline: Positive Test of Submitting the order
    # Step to perform login using credentials provided in Examples
    Given Logged in with username <name> and password <password>

    # Step to add a specific product to the shopping cart
    When I add the product <productName> to Card

    # Step to proceed to checkout and submit the order for a specified country
    And Checkout <productName> and submit the order for <country>

    # Final step to verify that the confirmation message is displayed
    Then Verify "THANKYOU FOR THE ORDER." message is displayed on ConfirmationPage

    # Test data used for scenario outline
    Examples: 
      | name             | password       | productName | country |
      # Test case with valid credentials and product details
      | test@gmail.com   | Password@1235  | ZARA COAT 3 | INDIA   |
