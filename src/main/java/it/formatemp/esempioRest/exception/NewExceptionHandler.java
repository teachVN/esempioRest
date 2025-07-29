package it.formatemp.esempioRest.exception;

import it.formatemp.esempioRest.model.ApiError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class NewExceptionHandler {

    @ExceptionHandler(ValidationException.class)
    public ApiError validationExceptionHandler(ValidationException e){
        ApiError error = new ApiError();
        error.setMessage(e.getMessage());
        error.setErrorTime(LocalDateTime.now());
        return error;
    }
}
