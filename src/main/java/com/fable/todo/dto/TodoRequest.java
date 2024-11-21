package com.fable.todo.dto;

import com.fable.todo.model.StatusOrder;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;


public class  TodoRequest {
    @NotNull(message = "Task cannot be blank")
    //@NotBlank(message = "Task name cannot be empty")
//    @Max(value = 100, message = "task name should be less than or equal to 100")
     private String taskName;
    private String status;
//    @Max(value = 20, message = "status should be less than or equal to 20")

//   @NotNull(message = "Status Can not be null")
//   @Enumerated(EnumType.STRING)         //It ensure that String type value can be only accepted
//   private StatusOrder taskStatus;

    public TodoRequest() {
    }

    public TodoRequest(String taskName,String status) {
        this.taskName = taskName;
           this.status = status;
    }

    public String getTaskName() {
        return taskName;
    }
    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
}
