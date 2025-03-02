package xyz.gvital.todo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import xyz.gvital.todo.model.TaskHistory;

import java.util.List;

public interface TaskHistoryRepository extends JpaRepository<TaskHistory, Long> {
    List<TaskHistory> findAllByTodoId(Long todoId);
}
