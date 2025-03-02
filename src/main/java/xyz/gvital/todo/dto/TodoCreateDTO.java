package xyz.gvital.todo.dto;

import lombok.Data;
import xyz.gvital.todo.model.Priority;

import java.time.LocalDateTime;

@Data
public class TodoCreateDTO {
    private String title;
    private String description;
    private LocalDateTime dueDate;
    private Priority priority;
}
