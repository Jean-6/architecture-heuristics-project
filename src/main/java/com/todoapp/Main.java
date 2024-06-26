package com.todoapp;

public class Main {

    public static void main(String[] args) {
      String filePath = "../../../../../tasks.txt";
        TaskRepository taskRepository = new InFileTaskRepository(filePath);
        TaskService taskService = new TaskService(taskRepository);
        MyApp app = new MyApp(taskService);
        app.run(args);
    }
}
