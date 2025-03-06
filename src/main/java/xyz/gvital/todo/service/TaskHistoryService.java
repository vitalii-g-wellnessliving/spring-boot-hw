package xyz.gvital.todo.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import xyz.gvital.todo.dto.TaskHistoryResponseDTO;
import xyz.gvital.todo.mapper.TaskHistoryMapper;
import xyz.gvital.todo.repository.TaskHistoryRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class TaskHistoryService {
    private final TaskHistoryMapper taskHistoryMapper;
    private final TaskHistoryRepository taskHistoryRepository;

    public List<TaskHistoryResponseDTO> list(Long todoId) {
        return taskHistoryMapper.toDto(taskHistoryRepository.findAllByTodoId(todoId));
    }
}
