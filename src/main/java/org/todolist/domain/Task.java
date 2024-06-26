package org.todolist.domain;
import org.todolist.domain.service.DateService;

import java.time.LocalDateTime;

import java.io.Serializable;
import java.util.UUID;

public class Task implements Serializable {
    private final UUID id;
    private final String description;
    private boolean isDone;
    private final LocalDateTime createdAt;
    private final DateService dateService;

    public Task(String description) {
        this.id = UUID.randomUUID();
        this.description = description;
        this.isDone = false;
        this.createdAt = LocalDateTime.now();
        this.dateService = new DateService();
    }

    public UUID getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public boolean isDone() {
        return isDone;
    }

    public void markDone() {
        this.isDone = true;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    @Override
    public String toString() {
        return "[" + id + "][" + (isDone ? "X" : " ") + "] " + description + " (" + dateService.getElapsedTime(createdAt) + ")";
    }
}
