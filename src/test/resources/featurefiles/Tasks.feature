Feature: Add task to user
  Scenario:
  Given I am in the "Tasks" page
  When I add a new task
    And the task is assigned to "Valeria Huszak"
    And the task subject is "Call back mr. Blue Sky"
    And the task priority is "normal"
    When I submit the task
    Then the task will appear in the recent view
