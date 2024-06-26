package com.todoapp;

import java.util.Arrays;
import java.util.List;

public final class CommandHandler {
	private TaskService taskService;

	public CommandHandler(TaskService taskService) {
			this.taskService = taskService;
	}

	public void handleCommand(String[] args) {
			if (args.length == 0) {
					showUsage();
					return;
			}

			Command command = Command.fromString(args[0]);
			switch (command) {
					case ADD:
							handleAddCommand(Arrays.copyOfRange(args, 1, args.length)); // pass the rest of the arguments to the handler method as a new array
							break;
					case DONE:
							handleDoneCommand(Arrays.copyOfRange(args, 1, args.length));
							break;
					case DELETE:
							handleDeleteCommand(Arrays.copyOfRange(args, 1, args.length));
							break;
					case LIST:
							handleListCommand();
							break;
					default:
							System.out.println("Unknown command: " + args[0]);
							showUsage();
							break;
			}
	}

	private void handleAddCommand(String[] args) {
			if (args.length < 1) {
					System.out.println("Usage: myapp add {description}");
			} else {
					String description = String.join(" ", args);
					taskService.addTask(description);
					System.out.println("Task added.");
			}
	}

	private void handleDoneCommand(String[] args) {
			if (args.length < 1) {
					System.out.println("Usage: myapp done {id}");
			} else {
					try {
							int id = Integer.parseInt(args[0]);
							taskService.updateTaskStatus(id, TaskStatus.COMPLETED);
							System.out.println("Task marked as done.");
					} catch (NumberFormatException e) {
							System.out.println("Invalid task id: " + args[0]);
					}
			}
	}

	private void handleDeleteCommand(String[] args) {
			if (args.length < 1) {
					System.out.println("Usage: myapp delete {id}");
			} else {
					try {
							int id = Integer.parseInt(args[0]);
							taskService.deleteTask(id);
							System.out.println("Task deleted.");
					} catch (NumberFormatException e) {
							System.out.println("Invalid task id: " + args[0]);
					}
			}
	}

	private void handleListCommand() {
			List<Task> tasks = taskService.getAllTasks();
			for (Task task : tasks) {
					System.out.println(task);
			}
	}

	private void showUsage() {
			System.out.println("Usage: myapp {command} {arguments}");
			System.out.println("Commands:");
			System.out.println("  add {description} - Add a new task with the given description");
			System.out.println("  done {id} - Mark the task with the given id as done");
			System.out.println("  delete {id} - Delete the task with the given id");
			System.out.println("  list - List all tasks");
	}
}
