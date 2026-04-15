@tag
Feature: Purechase ther order from ecom site
I want use this template for my feature file

  Background:
    Given I landed on ecommerce page

  @regression
  Scenario Outline: Positive test of submitting the order.
    Given Logged in with username <username> and password <password>
    When I add product <productName> to cart
    And Checkout <productName> and submit the order
    Then "THANKYOU FOR THE ORDER." message is displayed on confirmation page

    Examples:
      | username                 | password  | productName |
      | pawarajitme182@gmail.com | Ajit@9767 | ZARA COAT 3 |
