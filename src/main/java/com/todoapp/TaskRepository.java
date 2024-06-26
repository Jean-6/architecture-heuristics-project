package com.todoapp;

import java.util.List;

public interface TaskRepository {
		void addTask(Task task);
		void deleteTask(int id);
		Task getTask(int id);
		List<Task> getAllTasks(); // by default ordered by creation date ascending
		List<Task> getTasksByStatus(TaskStatus status); // ordered by creation date ascending
		void updateTaskStatus(int id, TaskStatus status);
		void updateTaskDescription(int id, String description);
}
