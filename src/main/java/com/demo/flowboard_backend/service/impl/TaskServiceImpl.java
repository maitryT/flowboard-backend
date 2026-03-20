package com.demo.flowboard_backend.service.impl;

import com.demo.flowboard_backend.model.Task;
import com.demo.flowboard_backend.model.User;
import com.demo.flowboard_backend.repository.TaskRepository;
import com.demo.flowboard_backend.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    TaskRepository taskRepository;

    @Override
    public Task saveTask(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public List<Task> getAllTask() {
        return taskRepository.findAll();
    }

    @Override
    public Task getTaskById(Long id) {
        return taskRepository.findById(id).orElse(null);
    }

    @Override
    public List<Task> getTaskByUser(Long uId) {
        return taskRepository.findByUserId(uId);
    }

    @Override
    public User updateTask(Long id, Task task) {

        Task existingTask = taskRepository.findById(id).orElse(null);
        if (existingTask != null) {
            existingTask.setTaskName(task.getTaskName());
            existingTask.setTaskDesc(task.getTaskDesc());
            existingTask.setStatus(task.getStatus());
            existingTask.setUserId(task.getUserId());
            taskRepository.save(existingTask);
        } else {
            throw new RuntimeException("Task not found");
        }
        return null;
    }

    @Override
    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }
}
