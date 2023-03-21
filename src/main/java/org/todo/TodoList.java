package org.todo;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.CollectionType;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TodoList {
    private ArrayList<Task> tasks;
    private final ObjectMapper mapper;
    private final File file;

    public TodoList(String filename) {
        this.tasks = new ArrayList<>();
        this.mapper = new ObjectMapper();
        this.file = new File(filename);

        if (file.exists()) {
            try {
                CollectionType type = mapper.getTypeFactory().constructCollectionType(List.class, Task.class);
                tasks = mapper.readValue(file, type);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void addTask(Task task) {
        tasks.add(task);
        saveToFile();
    }

    public void removeTask(int index) {
        tasks.remove(index);
        saveToFile();
    }

    public void displayAllTasks() {
        System.out.println("Todo List:");
        for (int i = 0; i < tasks.size(); i++) {
            Task task = tasks.get(i);
            System.out.println(i + 1 + ". [" + (task.isCompleted() ? "x" : " ") + "] " + task.getName() + " - " + task.getDescription());
        }
    }

    public void markTaskCompleted(int index) {
        Task task = tasks.get(index);
        task.markCompleted();
        saveToFile();
        System.out.println("Task \"" + task.getName() + "\" marked as completed.");
    }

    public void markTaskIncomplete(int index) {
        Task task = tasks.get(index);
        task.markIncomplete();
        saveToFile();
        System.out.println("Task \"" + task.getName() + "\" marked as incomplete.");
    }

    private void saveToFile() {
        try {
            mapper.writeValue(file, tasks);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
