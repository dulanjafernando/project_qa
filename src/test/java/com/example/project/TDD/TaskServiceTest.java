package com.example.project.TDD;

import com.example.project.model.Task;
import com.example.project.service.TaskService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TaskServiceTest {

    private TaskService taskService;

    @BeforeEach
    void setUp() {
        taskService = new TaskService();
    }

    @Test
    void testAddTaskAddsNewTask() {
        // Red: The test should fail initially because the service's addTask method is not yet implemented or is empty.
        taskService.addTask("Buy groceries");

        // Green: After implementing the logic in TaskService, this assertion should pass.
        assertEquals(1, taskService.getAllTasks().size());
        assertEquals("Buy groceries", taskService.getAllTasks().get(0).getName());
    }
}