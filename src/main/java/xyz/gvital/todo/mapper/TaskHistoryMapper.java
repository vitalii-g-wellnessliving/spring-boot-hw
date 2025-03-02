package xyz.gvital.todo.mapper;

import org.mapstruct.Mapper;
import xyz.gvital.todo.config.MapperConfig;
import xyz.gvital.todo.dto.TaskHistoryResponseDTO;
import xyz.gvital.todo.model.TaskHistory;

import java.util.List;

@Mapper(config = MapperConfig.class)
public interface TaskHistoryMapper {
    TaskHistoryResponseDTO toDto(TaskHistory model);

    List<TaskHistoryResponseDTO> toDto(List<TaskHistory> model);
}
