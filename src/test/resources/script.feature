Feature: Test select expensive
  As user select expensive product and add to card
  Scenario Outline: Test select
    Given User input '<product>'


    Examples:
    | product |