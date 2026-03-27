package com.demo.flowboard_backend.controller;

import com.demo.flowboard_backend.model.Task;
import com.demo.flowboard_backend.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/tasks")
public class TaskController {

    @Autowired
    TaskService taskService;


    @GetMapping
    ResponseEntity<List<Task>> getAllTask() {
        return ResponseEntity.ok(taskService.getAllTask());
    }

    @PostMapping
    ResponseEntity<Task> createTask(@RequestBody Task task) {
        return ResponseEntity.ok(taskService.saveTask(task));
    }

    @PutMapping("/{taskId}/user/{userId}")
    ResponseEntity<String> assignTask(@PathVariable Long taskId, @PathVariable Long userId) {

        try{
            return   ResponseEntity.ok(taskService.assignTask(taskId, userId));
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/users/{userId}")
    ResponseEntity<List<Task>> getTaskByUser(@PathVariable Long userId) {
        return ResponseEntity.ok(taskService.getTaskByUser(userId));
    }
}
