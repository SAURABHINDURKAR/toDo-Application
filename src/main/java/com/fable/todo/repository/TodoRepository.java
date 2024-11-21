package com.fable.todo.repository;

import com.fable.todo.entity.TodoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

//CRUD Query Operation

@Repository
public interface TodoRepository extends JpaRepository<TodoEntity, Integer> {

    List<TodoEntity> findByStatus(String status);
    List<TodoEntity> findByStatusAndTaskName(String status, String taskName);

    void deleteTaskById(Integer id);
}
