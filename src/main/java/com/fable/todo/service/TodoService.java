package com.fable.todo.service;

import com.fable.todo.dto.TodoRequest;
import com.fable.todo.entity.TodoEntity;
import com.fable.todo.model.StatusOrder;

import java.util.List;

public interface TodoService {

    TodoEntity insertTask(TodoRequest todoRequest);

    TodoEntity updateTask(Integer id, TodoRequest todoRequest);

    //TodoEntity getTaskById();
    TodoEntity getTaskById(Integer id);

    List<TodoEntity> getAllTask();

    TodoEntity deleteTaskById(Integer id);

   // StatusOrder STATUS_ORDER(StatusOrder statusOrder);

}
