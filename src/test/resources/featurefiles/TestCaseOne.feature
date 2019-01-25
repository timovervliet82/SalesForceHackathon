Feature: Add new contact person

  Scenario Outline: Create a new contact person
    Given I am on Sales Force Home page
    When I add a new contact person named "<lastname>"

    Examples:
      |lastname |
      |Blauw    |
      |Rood     |
      |Rood     |
      |Rood     |
      |Blauw    |
      |Blauw    |
      |Oranje   |

