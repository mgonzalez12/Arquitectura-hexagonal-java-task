package com.mgonzalez.springbootsecurityjwt.application.mapper;

import com.mgonzalez.springbootsecurityjwt.domain.model.Task;
import com.mgonzalez.springbootsecurityjwt.domain.model.dto.TaskDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TaskDtoMapper {


    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "description", target = "description")
    @Mapping(source = "timeRequiredToComplete", target = "timeRequiredToComplete")
    TaskDto toDto(Task domain);

}
