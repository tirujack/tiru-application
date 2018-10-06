package com.tiru.rest.bean.model;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by oustlabs on 06/10/18.
 */
public class Todo {
    private int todoId;
    private String title;
    private String description;
    private boolean isCompleted;
    private String scheduledAt;
    private String completedOn;
    private String createdDateTime;
    private boolean isdeleted;

    public int getTodoId() {
        return todoId;
    }

    public void setTodoId(int todoId) {
        this.todoId = todoId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }

    public String getScheduledAt() {
        return scheduledAt;
    }

    public void setScheduledAt(String scheduledAt) {
        this.scheduledAt = scheduledAt;
    }

    public String getCompletedOn() {
        return completedOn;
    }

    public void setCompletedOn(String completedOn) {
        this.completedOn = completedOn;
    }

    public String getCreatedDateTime() {
        return createdDateTime;
    }

    public void setCreatedDateTime(String createdDateTime) {
        this.createdDateTime = createdDateTime;
    }

    public boolean isdeleted() {
        return isdeleted;
    }

    public void setIsdeleted(boolean isdeleted) {
        this.isdeleted = isdeleted;
    }

    @Override
    public String toString() {
        return "Todo{" +
                "todoId=" + todoId +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", isCompleted=" + isCompleted +
                ", scheduledAt='" + scheduledAt + '\'' +
                ", completedOn='" + completedOn + '\'' +
                ", createdDateTime='" + createdDateTime + '\'' +
                ", isdeleted=" + isdeleted +
                '}';
    }
}
