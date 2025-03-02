package xyz.gvital.todo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import xyz.gvital.todo.model.Todo;

public interface TodoRepository extends JpaRepository<Todo, Long> {
}
