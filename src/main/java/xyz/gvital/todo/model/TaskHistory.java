package xyz.gvital.todo.model;

import jakarta.persistence.*;
import lombok.Data;

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

    private LocalDateTime changedAt;
    private Long changedBy;

}
