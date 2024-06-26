package org.todolist.domain.service;


import org.todolist.adapter.controller.display.ConsoleDisplayAdapter;
import org.todolist.domain.Task;
import org.todolist.ports.input.TaskInputPort;
import org.todolist.ports.output.TaskRepository;

import java.util.List;
import java.util.UUID;

public class TaskService implements TaskInputPort {
    private final TaskRepository taskRepository;
    private final ConsoleDisplayAdapter displayAdapter;
    private final DateService dateService;

    public TaskService(TaskRepository taskRepository, ConsoleDisplayAdapter displayAdapter, DateService dateService) {
        this.taskRepository = taskRepository;
        this.displayAdapter = displayAdapter;
        this.dateService = dateService;
    }

    @Override
    public void handleInput(String input) {
        String[] parts = input.split(" ", 2);
        String command = parts[0];
        String argument = parts.length > 1 ? parts[1] : "";

        switch (command) {
            case "add":
                addTask(argument);
                break;
            case "list":
                listTasks();
                break;
            case "done":
                markTaskDone(UUID.fromString(argument));
                break;
            case "remove":
                removeTask(UUID.fromString(argument));
                break;
            default:
                displayAdapter.display("Unknown command.");
        }
    }

    public void addTask(String description) {
        Task task = new Task(description);
        taskRepository.save(task);
        displayAdapter.display("Task added: " + description);
    }

    public void listTasks() {
        List<Task> tasks = taskRepository.findAll();
        tasks.forEach(task -> displayAdapter.display(task.toString()));
    }

    public void markTaskDone(UUID taskId) {
        taskRepository.findById(taskId).ifPresent(task -> {
            task.markDone();
            taskRepository.save(task);
            displayAdapter.display("Task marked as done: " + taskId);
        });
    }

    public void removeTask(UUID taskId) {
        taskRepository.delete(taskId);
        displayAdapter.display("Task removed: " + taskId);
    }
}
