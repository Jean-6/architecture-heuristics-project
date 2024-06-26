package com.todoapp;

public class MyApp {
	private CommandHandler commandHandler;

	public MyApp(TaskService taskService) {
			this.commandHandler = new CommandHandler(taskService);
	}

	public void run(String[] args) {
			commandHandler.handleCommand(args);
	}
}
