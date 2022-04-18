package com.projects.Homepage.Todos;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

@SpringBootTest
class TodoControllerTest {

    @Autowired
    TodoRepository todoRepositoryMock;// = mock(TodoRepository.class);

    @Test
    void getAllTodos() {

        assertEquals(todoRepositoryMock.findAll().getClass(), ArrayList.class);
    }

    @Test
    void getTodoMock() {

        long id = 16;
        assertEquals(todoRepositoryMock.findById(id).get().getId(), id);
    }

}