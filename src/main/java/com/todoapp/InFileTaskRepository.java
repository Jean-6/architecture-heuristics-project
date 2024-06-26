package com.todoapp;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class InFileTaskRepository implements TaskRepository {

	private String filePath;

	public InFileTaskRepository(String filePath) {
		this.filePath = filePath;
	}

	private void writeTasksToFile(List<Task> tasks) {
        // try (PrintWriter writer = new PrintWriter(new FileWriter(filePath))) {
        //     for (Task task : tasks) {
        //         writer.printf("%d,%s,%s,%s%s,%n", task.getId(), task.getDescription(), task.getStatus(), task.getTimeElapsedSinceCreation(), task.getCreationDate());
        //     }
        // } catch (IOException e) {
        //     e.printStackTrace();
        // }
				try (
					ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            // oos.writeObject(tasks);
						for (Task task : tasks) {
								// oos.writeObject(task);
								// write the task to file in a format that can be read back
								oos.writeObject(task.getId() + "," + task.getDescription() + "," + task.getStatus() + "," + task.getTimeElapsedSinceCreation() + "," + task.getCreationDate());
						}
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

	@Override
	public void addTask(Task task) {
		System.out.println("Adding task: " + task.getDescription());
		List<Task> tasks = getAllTasks();
        tasks.removeIf(t -> t.getId() == task.getId());
        tasks.add(task);
        writeTasksToFile(tasks);
	}

	@Override
	public void deleteTask(int id) {
		List<Task> tasks = getAllTasks();
        tasks.removeIf(t -> t.getId() == id);
        writeTasksToFile(tasks);
	}

	@Override
	public Task getTask(int id) {
		List<Task> tasks = getAllTasks();
				for (Task task : tasks) {
						if (task.getId() == id) {
								return task;
						}
				}
				return null;
	}

	@Override
	public List<Task> getAllTasks() {
		List<Task> tasks = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                int id = Integer.parseInt(parts[0]);
                String description = parts[1];
                TaskStatus status = TaskStatus.valueOf(parts[2]);
                @SuppressWarnings("unused")
								String timeElapsed = parts[3];
								// Date createdAt = new Date(parts[4]);
								// conversion to obtain Instant from TemporalAccessor: 2024-06-26T23:35:45.520891 of type java.time.LocalDateTime
								Date createdAt = Date.from(Instant.from(LocalDateTime.parse(parts[4])));
								tasks.add(new Task(id, description, status, createdAt));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return tasks;
	}

	@Override
	public List<Task> getTasksByStatus(TaskStatus status) {
		List<Task> tasks = getAllTasks();
				List<Task> tasksByStatus = new ArrayList<>();
				for (Task task : tasks) {
						if (task.getStatus() == status) {
								tasksByStatus.add(task);
						}
				}
				return tasksByStatus;
	}

	@Override
	public void updateTaskStatus(int id, TaskStatus status) {
		List<Task> tasks = getAllTasks();
				for (Task task : tasks) {
						if (task.getId() == id) {
								task.setStatus(status);
								writeTasksToFile(tasks);
								return;
						}
				}
	}

	@Override
	public void updateTaskDescription(int id, String description) {
		List<Task> tasks = getAllTasks();
				for (Task task : tasks) {
						if (task.getId() == id) {
								task.setDescription(description);
								writeTasksToFile(tasks);
								return;
						}
				}
	}

}
