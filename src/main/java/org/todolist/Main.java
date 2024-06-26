package org.todolist;

import org.todolist.adapter.controller.cli.CommandLineInputReceptor;
import org.todolist.adapter.controller.display.ConsoleDisplayAdapter;
import org.todolist.domain.service.DateService;
import org.todolist.domain.service.TaskService;
import org.todolist.ports.output.TaskRepository;
import org.todolist.repository.FileTaskPersistence;

public class Main {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("No command provided.");
            return;
        }

        TaskRepository taskRepository = new FileTaskPersistence("tasks.dat");
        ConsoleDisplayAdapter displayAdapter = new ConsoleDisplayAdapter();
        TaskService taskService = new TaskService(taskRepository, displayAdapter, new DateService());

        CommandLineInputReceptor receptor = new CommandLineInputReceptor(taskService);

        receptor.handleCommand(args);
    }
}
