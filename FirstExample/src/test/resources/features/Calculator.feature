Feature: Calculator Operators

  Scenario: User enters simple calculation
    Given the calculator is started
    When the user enters "1+1"
    Then the calculator should display "2"

  Scenario: User enters real number calculation with integer result
    Given the calculator is started
    When the user enters "1.5+1.5"
    Then the calculator should display "3"

  Scenario: User enters real calculation with real result
    Given the calculator is started
    When the user enters "1.5+1"
    Then the calculator should display "2.5"



