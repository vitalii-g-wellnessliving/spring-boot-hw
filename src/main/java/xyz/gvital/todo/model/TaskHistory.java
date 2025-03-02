package xyz.gvital.todo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Data
public class TaskHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Todo todo;

    private String oldState;
    private String newState;

    @CreationTimestamp
    private LocalDateTime changedAt;

    private Long changedBy;

    @PrePersist
    @PreUpdate
    public void prePersist() {
        this.changedBy = 1L;
    }
}
