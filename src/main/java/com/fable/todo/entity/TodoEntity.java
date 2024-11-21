package com.fable.todo.entity;

import com.fable.todo.model.StatusOrder;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "todo_table")
public class TodoEntity {

    //private String  status;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

   // @NotNull(message = "Please Provide Task Name")
    private String taskName;
    private String status;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date taskDate;

    public TodoEntity() {
    }

    public TodoEntity(String taskName) {
        this.taskName = taskName;
        this.taskDate = new Date();
    }
//ID
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
//TASK NAME
    public String getTaskName() {
        return taskName;
    }
    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }
//STATUS
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    public Date getTaskDate() {
        return taskDate;
    }
    public void setTaskDate(Date taskDate) {
        this.taskDate = taskDate;
    }


}
