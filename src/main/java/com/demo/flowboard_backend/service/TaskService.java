package com.demo.flowboard_backend.service;

import com.demo.flowboard_backend.model.Task;
import com.demo.flowboard_backend.model.User;

import java.util.List;

public interface TaskService {

    Task saveTask(Task task);

    List<Task> getAllTask();

    Task getTaskById(Long id);

    List<Task> getTaskByUser(Long uId);

    User updateTask(Long id, Task task);

    String assignTask(Long taskId, Long userId);

    void deleteTask(Long id);
}
