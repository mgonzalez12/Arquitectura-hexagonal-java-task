package com.mgonzalez.springbootsecurityjwt.infraestructure.adapter.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TaskEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String description;
    private boolean completed;
    private LocalDateTime dateOfCreation;
    private int timeRequiredToComplete;

    public TaskEntity(Long id) {
        this.id = id;
    }

    public void setInitialValues(){
        this.completed = false;
        this.dateOfCreation = LocalDateTime.now();
    }
}
