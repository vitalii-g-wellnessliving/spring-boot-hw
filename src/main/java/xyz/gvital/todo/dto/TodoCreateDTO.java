package xyz.gvital.todo.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import xyz.gvital.todo.model.Priority;

import java.time.LocalDateTime;

@Data
public class TodoCreateDTO {
    @NotEmpty
    @Size(max = 100)
    private String title;

    @Size(max = 500)
    private String description;

    @NotNull
    private LocalDateTime dueDate;

    private Priority priority;
}
