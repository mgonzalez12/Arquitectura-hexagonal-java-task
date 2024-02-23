package com.mgonzalez.springbootsecurityjwt.infraestructure.adapter;

import com.mgonzalez.springbootsecurityjwt.domain.model.Task;
import com.mgonzalez.springbootsecurityjwt.domain.model.constant.TaskContant;
import com.mgonzalez.springbootsecurityjwt.domain.port.TaskPersistencePort;
import com.mgonzalez.springbootsecurityjwt.infraestructure.adapter.exception.TaskException;
import com.mgonzalez.springbootsecurityjwt.infraestructure.adapter.mapper.TaskDboMapper;
import com.mgonzalez.springbootsecurityjwt.infraestructure.adapter.repository.TaskRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class TaskSpringJpaAdapter implements TaskPersistencePort {

    private final TaskRepository taskRepository;
    private final TaskDboMapper taskDboMapper;

    public TaskSpringJpaAdapter(TaskRepository taskRepository, TaskDboMapper taskDboMapper) {
        this.taskRepository = taskRepository;
        this.taskDboMapper = taskDboMapper;
    }

    @Override
    public Task create(Task request) {
        var taskToSave = taskDboMapper.toDbo(request);
        var taskSaved = taskRepository.save(taskToSave);
        return taskDboMapper.toDomain(taskSaved);
    }

    @Override
    public Task getById(Long id) {
        var optionalTask = taskRepository.findById(id);

        if (optionalTask.isEmpty()) {
            throw new TaskException(HttpStatus.NOT_FOUND, String.format(TaskContant.TASK_NOT_FOUND_MESSAGE_ERROR, id));
        }
        return taskDboMapper.toDomain(optionalTask.get());
    }

    @Override
    public List<Task> getAll() {
        return taskRepository.findAll()
                .stream()
                .map(taskDboMapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public void deleteById(Long id) {
        taskRepository.deleteById(id);
    }

    @Override
    public Task update(Task task) {
        var taskToUpdate = taskDboMapper.toDbo(task);
        var taskUpdated = taskRepository.save(taskToUpdate);
        return taskDboMapper.toDomain(taskUpdated);
    }

    @Override
    public List<Task> getByIds(List<Long> tasksIds) {
        return taskRepository.findByIdIn(tasksIds)
                .stream()
                .map(taskDboMapper::toDomain)
                .collect(Collectors.toList());
    }
}
