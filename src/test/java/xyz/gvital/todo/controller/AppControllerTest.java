package xyz.gvital.todo.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.transaction.annotation.Transactional;
import xyz.gvital.todo.dto.TodoCreateDTO;
import xyz.gvital.todo.model.Priority;

import java.time.LocalDateTime;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@Transactional
class AppControllerTest {
    @Autowired
    protected MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;

    @Test
    @Rollback
    @DisplayName("Create a new product")
    void createTodo_ValidRequestDto_Success() throws Exception {

        TodoCreateDTO todoCreateDTO = new TodoCreateDTO();
        todoCreateDTO.setTitle("Test");
        todoCreateDTO.setDescription("Test description");
        todoCreateDTO.setPriority(Priority.HIGH);
        todoCreateDTO.setDueDate(LocalDateTime.now());

        mockMvc.perform(MockMvcRequestBuilders.post("/todos")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(todoCreateDTO)))
                .andExpect(status().isOk());

    }
}
