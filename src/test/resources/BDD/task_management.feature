Feature: Task Management
  As a user, I want to manage my tasks so that I can track my work efficiently.

  Scenario: Add a new task
    Given a clean task list
    When the user adds a new task named "Buy groceries"
    Then the task list should contain 1 task
    And the task named "Buy groceries" should exist