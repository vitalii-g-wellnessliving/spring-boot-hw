package xyz.gvital.todo.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import xyz.gvital.todo.config.MapperConfig;
import xyz.gvital.todo.dto.TodoCreateDTO;
import xyz.gvital.todo.dto.TodoResponseDTO;
import xyz.gvital.todo.dto.TodoUpdateDTO;
import xyz.gvital.todo.model.Todo;

@Mapper(config = MapperConfig.class)
public interface TodoMapper {

    Todo toModel(TodoCreateDTO dto);

    void updateModel(TodoUpdateDTO dto, @MappingTarget Todo model);

    TodoResponseDTO toDto(Todo model);

}
