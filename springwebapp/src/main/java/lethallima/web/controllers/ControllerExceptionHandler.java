package lethallima.web.controllers;

import org.springframework.dao.DataAccessException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Created by LethalLima on 6/14/16.
 */

@ControllerAdvice
public class ControllerExceptionHandler {
    @ExceptionHandler(DataAccessException.class)
    public String handleDatabaseException(DataAccessException e){
        e.printStackTrace();
        return "database/error";
    }
}
