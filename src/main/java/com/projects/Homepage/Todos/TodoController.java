package com.projects.Homepage.Todos;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@CrossOrigin(origins="http://localhost:4200")
@RestController
public class TodoController {

    @Autowired
    TodoRepository todoRepository;

/*    @GetMapping("/todoList/allTodos")
    public List<Todo> getAllTodos(){
        return todoRepository.findAll();
    }*/

    @GetMapping("/todoList/allTodos")
    public Iterable<Todo> getAllTodos(){
        return todoRepository.findAll();
    }


    @GetMapping(path="/todoList/{id}")
    public Todo getTodo(@PathVariable long id){
        return todoRepository.findById(id).get();
    }

    @DeleteMapping("/todoList/{id}")
    public ResponseEntity<Void> deleteTodo(@PathVariable long id){

        todoRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("todoList/{id}")
    public Todo updateTodo(@PathVariable int id, @RequestBody Todo newTodo){
        Todo result = todoRepository.save(newTodo);

        return result;
    }

    @PostMapping(path = "/todoList/createTodo")
    public Todo createTodo(@RequestBody Todo newTodo){
        Todo result = todoRepository.save(newTodo);

        // nach einer POST request wollen wir die URL des erstellen Objektes wiedergeben
        // in diesem Fall "/users/{username}/todos}" + die neue ID

        // schnappt sich die URL der request
/*        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(result.getId()).toUri();
        return  ResponseEntity.created(uri).build();*/
        //alternative returne einfach die Todo

        return result;
    }
}
