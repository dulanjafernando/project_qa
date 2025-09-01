package com.example.project.service;

import com.example.project.model.Task;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskService {
    private final List<Task> tasks = new ArrayList<>();

    public void addTask(String taskName) {
        if (taskName != null && !taskName.trim().isEmpty()) {
            tasks.add(new Task(taskName));
        }
    }

    public List<Task> getAllTasks() {
        return tasks;
    }
}