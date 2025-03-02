package xyz.gvital.todo.service;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import xyz.gvital.todo.dto.TodoCreateDTO;
import xyz.gvital.todo.dto.TodoResponseDTO;
import xyz.gvital.todo.dto.TodoUpdateDTO;
import xyz.gvital.todo.exception.EntityNotFoundException;
import xyz.gvital.todo.mapper.TodoMapper;
import xyz.gvital.todo.model.Todo;
import xyz.gvital.todo.repository.TodoRepository;

@Service
@AllArgsConstructor
public class TodoService {
    private final TodoMapper todoMapper;

    private final TodoRepository todoRepository;

    public TodoResponseDTO create(TodoCreateDTO dto) {
        Todo model = todoMapper.toModel(dto);
        model.addHistory("", model.toString());

        return todoMapper.toDto(todoRepository.save(model));
    }

    @Transactional
    public TodoResponseDTO update(Long id, TodoUpdateDTO dto) {
        Todo model = todoRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Can't find todo by id: " + id));
        String oldState = model.toString();
        todoMapper.updateModel(dto, model);
        model.addHistory(oldState, model.toString());

        return todoMapper.toDto(todoRepository.save(model));
    }

    public void delete(Long id) {
        todoRepository.deleteById(id);
    }

}
