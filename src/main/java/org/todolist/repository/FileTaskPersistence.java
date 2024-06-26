package org.todolist.repository;

import org.todolist.domain.Task;
import org.todolist.ports.output.TaskRepository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class FileTaskPersistence implements TaskRepository {
    private final String filePath;

    public FileTaskPersistence(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public void save(Task task) {
        List<Task> tasks = findAll();
        tasks.add(task);
        saveTasksToFile(tasks);
    }

    @Override
    public List<Task> findAll() {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filePath))) {
            return (List<Task>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            return new ArrayList<>();
        }
    }

    @Override
    public Optional<Task> findById(UUID id) {
        return findAll().stream().filter(task -> task.getId().equals(id)).findFirst();
    }

    @Override
    public void delete(UUID id) {
        List<Task> tasks = findAll();
        tasks.removeIf(task -> task.getId().equals(id));
        saveTasksToFile(tasks);
    }

    private void saveTasksToFile(List<Task> tasks) {
        try (
                ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filePath))) {
            oos.writeObject(tasks);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}