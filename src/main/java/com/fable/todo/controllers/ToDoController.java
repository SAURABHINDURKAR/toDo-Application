package com.fable.todo.controllers;

import com.fable.todo.dto.TodoRequest;
import com.fable.todo.entity.TodoEntity;
import com.fable.todo.model.StatusOrder;
import com.fable.todo.service.TodoService;
import jakarta.validation.Valid;
import org.aspectj.bridge.IMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Validated
public class ToDoController {

    @Autowired
    private TodoService todoService;


    @GetMapping("/fetch")
    public List<TodoEntity> fetchFullData() {
        List<TodoEntity> getaAllData =todoService.getAllTask();
        return getaAllData;
    }

    @GetMapping("/fetch/{id}")
    public ResponseEntity<TodoEntity> fetchData(@PathVariable("id") Integer id) {
    TodoEntity getData = todoService.getTaskById(id);
    //public ResponseEntity<TodoEntity> fetchData() {
      //  TodoEntity getData = todoService.getTaskById();
        return new ResponseEntity<>(getData, HttpStatus.OK);
    }

    @PostMapping("/insert")
    public ResponseEntity<TodoEntity> insertTask(@RequestBody TodoRequest todoRequest) {

        TodoEntity todo1 = todoService.insertTask(todoRequest);
        return new ResponseEntity<>(todo1, HttpStatus.CREATED);  //201 cretaed,   200 OK,
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<TodoEntity> fetchData( @PathVariable("id") Integer id, @RequestBody @Valid TodoRequest todoRequest) {
            TodoEntity updatedData = todoService.updateTask(id, todoRequest);
        return new ResponseEntity<>(updatedData, HttpStatus.OK);
    }

@DeleteMapping("/delete/{id}")

    public TodoEntity deleteTask(@PathVariable("id") Integer id){
    TodoEntity delData= todoService.deleteTaskById(id);

    return delData;
    }
}
