package com.example.project.controller;

import com.example.project.model.Task;
import com.example.project.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
//dsddada
//adad
@RestController
@RequestMapping("/api/tasks")
public class TaskController {
    @Autowired
    private final TaskService taskService = new TaskService();

    @PostMapping("/add")
    public String addTask(@RequestParam String taskName) {
        taskService.addTask(taskName);
        return "Task added: " + taskName;
    }

    @GetMapping
    public List<Task> getTasks() {
        return taskService.getAllTasks();
    }
}