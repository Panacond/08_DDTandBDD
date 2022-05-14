Feature: Test select expensive
  As user select expensive product and add to card

  Scenario Outline: Test select
    Given User input '<product>' in search field
    And User check '<brand>'
    And User select '<select>'
    When User add first element to bucket
    Then The price in the cart is higher than the '<price>'

    Examples:
      | product | brand | price | select |
      | ноутбук | MSI   | 5000  | " От дорогих к дешевым " |