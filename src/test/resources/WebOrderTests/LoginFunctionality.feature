Feature: Testing Log in functionality

  Scenario: Testing Log in functionality with valid credentials
    # Gherkin language
    Given User navigates to WebOrders application
    When User provides username "Tester" and password "test"
    Then User validates that application "is" logged in

    Scenario: Testing log in functionality with invalid credentials
      Given User navigates to WebOrders application
      When  User provides username "Tester" and password "Tester"
      Then User validates that application "is not" logged in
