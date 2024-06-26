package com.todoapp;

import java.time.LocalDateTime;
import java.util.Date;

public class Task {
		private int id;
    private String description;
    private TaskStatus status;
    private Date createdAt; // will be used to tell since when the task is in the system

		public Task(int id, String description, TaskStatus status, Date createdAt) {
				this.id = id;
				this.description = description;
				// this.status = TaskStatus.TODO;
				// this.createdAt = LocalDateTime.now();
				// if not provided, we will use the current time
				this.status = status;
				this.createdAt = createdAt;
		}

		public String getDescription() {
				return description;
		}

		public TaskStatus getStatus() {
				return status;
		}

		public int getId() {
				return id;
		}

		public Date getCreationDate() {
				return createdAt;
		}

		public void setStatus(TaskStatus status) {
				this.status = status;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public String getTimeElapsedSinceCreation() {
				Date now = new Date();
				long diff = now.getTime() - createdAt.getTime();
				long diffSeconds = diff / 1000 % 60;
				long diffMinutes = diff / (60 * 1000) % 60;
				long diffHours = diff / (60 * 60 * 1000) % 24;
				long diffDays = diff / (24 * 60 * 60 * 1000);
				if (diffDays > 0) {
						return diffDays + " days";
				} else if (diffHours > 0) {
						return diffHours + " hours";
				} else if (diffMinutes > 0) {
						return diffMinutes + " minutes";
				} else {
						return diffSeconds + " seconds";
				}
		}


}
