package org.todolist.ports.output;

import org.todolist.domain.Task;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface TaskRepository {
    void save(Task task);

    List<Task> findAll();

    Optional<Task> findById(UUID id);

    void delete(UUID id);
}