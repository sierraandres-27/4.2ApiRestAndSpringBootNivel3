package cat.itacademy.s04.t02.n03.exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(FruitNotFoundException.class)
    public ResponseEntity<String> handlerFruitNotFoundException (FruitNotFoundException exception){

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());

    }


    @ExceptionHandler(Exception.class)
    public ResponseEntity<String>handlerGenericException (Exception exception){

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());

    }

}
