@tag
Feature: Error validation
I want use this template for my feature file

  

  @tag2
  Scenario Outline: Title of your screnarios.
    Given I landed on ecommerce page
    When Logged in with username <username> and password <password>
    Then "Incorrect email or password." message is displayed

    Examples:
      | username                 | password |
      | pawarajitme182@gmail.com | Ajit@976 |
