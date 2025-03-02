package xyz.gvital.todo.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TaskHistoryResponseDTO {
    private Long id;
    private Long todoId;
    private String oldState;
    private String newState;
    private LocalDateTime changedAt;
    private Long changedBy;
}
