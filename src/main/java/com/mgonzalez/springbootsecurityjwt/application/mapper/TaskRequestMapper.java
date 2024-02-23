package com.mgonzalez.springbootsecurityjwt.application.mapper;

import com.mgonzalez.springbootsecurityjwt.domain.model.Task;
import com.mgonzalez.springbootsecurityjwt.domain.model.dto.request.TaskRequest;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TaskRequestMapper {


    @Mapping(source = "name", target = "name")
    @Mapping(source = "description", target = "description")
    @Mapping(source = "timeRequiredToComplete", target = "timeRequiredToComplete")
    Task toDomain(TaskRequest request);

}
