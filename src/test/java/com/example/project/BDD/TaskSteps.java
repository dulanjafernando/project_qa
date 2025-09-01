package com.example.project.BDD;

import com.example.project.service.TaskService;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TaskSteps {

    // Inject the TaskService bean from the Spring context
    @Autowired
    private TaskService taskService;

    @Given("a clean task list")
    public void a_clean_task_list() {
        // Clear tasks to ensure a clean state for the scenario
        taskService.getAllTasks().clear();
    }

    @When("the user adds a new task named {string}")
    public void the_user_adds_a_new_task_named(String taskName) {
        taskService.addTask(taskName);
    }

    @Then("the task list should contain {int} task")
    public void the_task_list_should_contain_task(Integer expectedCount) {
        assertEquals(expectedCount.intValue(), taskService.getAllTasks().size());
    }

    @Then("the task named {string} should exist")
    public void the_task_named_should_exist(String taskName) {
        boolean taskExists = taskService.getAllTasks().stream()
                .anyMatch(task -> task.getName().equals(taskName));
        assertTrue(taskExists);
    }
}