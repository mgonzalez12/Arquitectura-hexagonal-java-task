package com.mgonzalez.springbootsecurityjwt.infraestructure.rest.advice;

import com.mgonzalez.springbootsecurityjwt.infraestructure.adapter.exception.TaskException;
import jdk.jshell.spi.ExecutionControl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MyControllerAdvice {

    @ExceptionHandler(TaskException.class)
    public ResponseEntity<String> handleEmptyInput(TaskException emptyInputException){
        return new ResponseEntity<String>(emptyInputException.getErrorMessage(), emptyInputException.getErrorCode());
    }

    @ExceptionHandler(ExecutionControl.UserException.class)
    public ResponseEntity<String> handleEmptyInput(ExecutionControl.UserException emptyInputException){
      //  return new ResponseEntity<String>(emptyInputException.getErrorMessage(), emptyInputException.getErrorCode());
        return  null;
    }

}
