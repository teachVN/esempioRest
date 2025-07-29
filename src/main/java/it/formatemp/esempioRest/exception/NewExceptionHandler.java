package it.formatemp.esempioRest.exception;

import it.formatemp.esempioRest.model.ApiError;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
//questa annotazione definisce questa classe come un controller delle eccezioni
@RestControllerAdvice
public class NewExceptionHandler {

    //l'annotazione ExceptionHandler serve come mappatura del metodo, per cui all'arrivo di una ValidationException
    //verrà chiamato questo metodo
    //ResponseStatus invece serve per ritornare uno stato diverso da 200OK
    @ExceptionHandler(ValidationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ApiError validationExceptionHandler(ValidationException e){
        ApiError error = new ApiError();
        error.setMessage(e.getMessage());
        error.setErrorTime(LocalDateTime.now());
        return error;
    }
}
