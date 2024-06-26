package com.todoapp;

import java.util.Date;
import java.util.List;

public class TaskService {
		private TaskRepository taskRepository;

		public TaskService(TaskRepository taskRepository) {
				this.taskRepository = taskRepository;
		}

		public void addTask(String description) {
				Task task = new Task(taskRepository.getAllTasks().size() + 1, description, TaskStatus.TODO, new Date());
				taskRepository.addTask(task);
		}

		public void deleteTask(int id) {
				taskRepository.deleteTask(id);
		}

		public Task getTask(int id) {
				return taskRepository.getTask(id);
		}

		public void updateTaskStatus(int id, TaskStatus status) {
				taskRepository.updateTaskStatus(id, status);
		}

		public void updateTaskDescription(int id, String description) {
				taskRepository.updateTaskDescription(id, description);
		}

		public List<Task> getTasksByStatus(TaskStatus status) {
				return taskRepository.getTasksByStatus(status);
		}

		public List<Task> getAllTasks() {
				return taskRepository.getAllTasks();
		}
}
