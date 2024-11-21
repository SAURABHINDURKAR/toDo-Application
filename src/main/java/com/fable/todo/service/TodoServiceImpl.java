package com.fable.todo.service;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.fable.todo.dto.TodoRequest;
import com.fable.todo.entity.TodoEntity;
import com.fable.todo.model.StatusOrder;
import com.fable.todo.repository.TodoRepository;
import org.aspectj.bridge.IMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class TodoServiceImpl implements TodoService {

    private final TodoRepository todoRepo;

    public enum STATUSENUM{
        TODO,
        PENDING,
        DONE
    }


    TodoEntity todoRepo1;
    /**
     * Types of dependency injection or autowire
     * 1. Constructor
     * 2. Setter method
     * 3. Field Inject
     */

    @Autowired
    public TodoServiceImpl(TodoRepository todoRepo) {
        this.todoRepo = todoRepo;
    }

    @Override
    public TodoEntity insertTask(TodoRequest todoRequest) {

        TodoEntity todoEntity = new TodoEntity(
                todoRequest.getTaskName()

        );
        todoEntity.setStatus(todoRequest.getStatus());

        TodoEntity todoResult = todoRepo.save(todoEntity);

        return todoResult;
    }

    @Override
    public TodoEntity updateTask(Integer id, TodoRequest todoRequest) {

        //todo: findById - get the TodoEntity
        Optional<TodoEntity> updateData= todoRepo.findById(id);

        //todo: make changes to TodoEntity by using setter method
        if(updateData.isPresent()) {
            TodoEntity todoEntity = updateData.get();
            todoEntity.setTaskName(todoRequest.getTaskName());

            TodoEntity updatedDate = todoRepo.save(todoEntity);
            return updatedDate;
        }return null;
    }

    @Override
    public List<TodoEntity> getAllTask() {
        List<TodoEntity> todoEntityList = todoRepo.findAll();
        return todoEntityList;
    }

    @Override
    public TodoEntity deleteTaskById(Integer id) {
        TodoRepository todoRepo2 = todoRepo;
        todoRepo2.deleteById(id);

         return null;
    }

    @Override
    public TodoEntity getTaskById(Integer id) {

        Optional<TodoEntity> resultById = todoRepo.findById(id);

//        if (resultById.isPresent()) return resultById.get();
//        else return null;
         return resultById.orElse(null);
    }


    public String updateStatus(TodoRequest todoRequest, String status){
        if(isValidStatus(status)){
            return "Status Updated to"+status;
        }else {
            return "Invalid status. Allowed values are: DONE, PENDING, TODO";
        }
 }


    private boolean isValidStatus(@org.jetbrains.annotations.NotNull String status) {
        try{
            STATUSENUM statusenum = STATUSENUM.valueOf(status.toUpperCase());
        return true;
        }catch(IllegalArgumentException e){
            return false;
        }
    }
}
