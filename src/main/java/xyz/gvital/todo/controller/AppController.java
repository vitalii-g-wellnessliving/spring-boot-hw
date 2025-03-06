package xyz.gvital.todo.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.gvital.todo.dto.TaskHistoryResponseDTO;
import xyz.gvital.todo.dto.TodoCreateDTO;
import xyz.gvital.todo.dto.TodoResponseDTO;
import xyz.gvital.todo.dto.TodoUpdateDTO;
import xyz.gvital.todo.service.TaskHistoryService;
import xyz.gvital.todo.service.TodoService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/todos")
public class ToDoController {
    private final TodoService todoService;
    private final TaskHistoryService taskHistoryService;

    @PostMapping
    public TodoResponseDTO create(@RequestBody @Valid TodoCreateDTO todo) {
        return todoService.create(todo);
    }

    @PutMapping("/{id}")
    public TodoResponseDTO update(@PathVariable Long id, @RequestBody TodoUpdateDTO todo) {
        return todoService.update(id, todo);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        todoService.delete(id);
    }

    @GetMapping("/{id}/history")
    public List<TaskHistoryResponseDTO> getTaskHistory(@PathVariable Long id) {
        return taskHistoryService.list(id);
    }
}
