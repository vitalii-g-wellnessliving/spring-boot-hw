package xyz.gvital.todo.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Todo {

    private static final ObjectMapper mapper = new ObjectMapper();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private LocalDateTime dueDate;
    private Priority priority;
    private Status status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Long userId;

    @Transient
    private Todo oldTodo;

    @OneToMany(mappedBy = "todo", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<TaskHistory> taskHistory;

    @PostLoad
    private void postLoad() {
        oldTodo = new Todo();
        oldTodo.id = this.id;
        oldTodo.title = this.title;
        oldTodo.description = this.description;
        oldTodo.dueDate = this.dueDate;
        oldTodo.priority = this.priority;
        oldTodo.status = this.status;
        oldTodo.createdAt = this.createdAt;
        oldTodo.updatedAt = this.updatedAt;
        oldTodo.userId = this.userId;
    }

    @PrePersist
    @PreUpdate
    private void addTaskHistory() {
        if (this.taskHistory == null) {
            this.taskHistory = new ArrayList<>();
        }

        TaskHistory taskHistory = new TaskHistory();
        taskHistory.setTodo(this);
        if (this.oldTodo != null) {
            taskHistory.setOldState(this.oldTodo.getTitle());
        }
        taskHistory.setNewState(this.getTitle());
        taskHistory.setChangedAt(LocalDateTime.now());
        taskHistory.setChangedBy(this.userId);

        this.taskHistory.add(taskHistory);
    }

    @Override
    public String toString() {
        try {
            return mapper.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            return super.toString();
        }
    }
}
