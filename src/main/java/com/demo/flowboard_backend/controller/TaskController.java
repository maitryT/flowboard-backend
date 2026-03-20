package com.demo.flowboard_backend.controller;

import com.demo.flowboard_backend.model.Task;
import com.demo.flowboard_backend.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaskController {

    @Autowired
    TaskService taskService;


    @GetMapping
    ResponseEntity<List<Task>> getAllTask(){
        return ResponseEntity.ok(taskService.getAllTask());
    }

    @PostMapping
    ResponseEntity<Task> createTask(@RequestBody Task task){
        return ResponseEntity.ok(taskService.saveTask(task));
    }
}
