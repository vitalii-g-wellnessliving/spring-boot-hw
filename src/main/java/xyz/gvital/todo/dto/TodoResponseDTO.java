package xyz.gvital.todo.dto;

import lombok.Data;
import xyz.gvital.todo.model.Priority;
import xyz.gvital.todo.model.Status;

import java.time.LocalDateTime;

@Data
public class TodoResponseDTO {
    private Long id;
    private String title;
    private String description;
    private LocalDateTime dueDate;
    private Priority priority;
    private Status status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Long userId;
}
