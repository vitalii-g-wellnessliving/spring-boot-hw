package xyz.gvital.todo.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
public class Todo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private LocalDateTime dueDate;

    @Enumerated(EnumType.STRING)
    private Priority priority;

    @Enumerated(EnumType.STRING)
    private Status status;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    private Long userId;

    @OneToMany(mappedBy = "todo", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<TaskHistory> taskHistory;

    @PrePersist
    public void prePersist() {
        this.status = Status.PENDING;
    }

    @Override
    public String toString() {
        return "{"
                + "\"title\": " + title + ","
                + "\"description\": " + description + ","
                + "\"dueDate\": " + dueDate + ","
                + "\"priority\": " + priority + ","
                + "\"status\": " + status
                + "}";
    }

    public void addHistory(String oldState, String newState) {
        TaskHistory history = new TaskHistory();
        history.setTodo(this);
        history.setOldState(oldState);
        history.setNewState(newState);
        if (taskHistory == null) {
            taskHistory = new ArrayList<>();
        }
        this.taskHistory.add(history);
    }

}
