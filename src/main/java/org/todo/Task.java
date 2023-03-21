package org.todo;
import com.fasterxml.jackson.annotation.JsonProperty;
public class Task {
    private String name;
    private String description;
    private boolean isCompleted;

    public Task() {}

    public Task(String name, String description) {
        this.name = name;
        this.description = description;
        this.isCompleted = false;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    @JsonProperty("completed")
    public void setCompleted(boolean completed) {
        this.isCompleted = completed;
    }

    public void markCompleted() {
        isCompleted = true;
    }

    public void markIncomplete() {
        isCompleted = false;
    }
}
