package xyz.gvital.todo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
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
public class AppController {
    private final TodoService todoService;
    private final TaskHistoryService taskHistoryService;

    @PostMapping
    public TodoResponseDTO create(@RequestBody TodoCreateDTO todo) {
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
