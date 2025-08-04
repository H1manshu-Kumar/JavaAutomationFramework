@tag
Feature: Error validation
  # Brief description of the feature under test
  I want to use this template for my feature file

    @tag2
  Scenario Outline: Title of your scenario outline
    # Step to navigate to the Ecommerce page
    Given I landed on Ecommerce Page

    # Step to perform login using parameters from Examples table
    When Logged in with username <name> and password <password>  

    # Step to verify the expected outcome using status parameter
    Then I verify the <status> in step

    # Example data sets to be used for this scenario outline
    Examples: 
      | name  | value | status  |
      # Test case 1 with name1, value 5, expecting success
      | name1 |     5 | success |
      # Test case 2 with name2, value 7, expecting failure
      | name2 |     7 | Fail    |
