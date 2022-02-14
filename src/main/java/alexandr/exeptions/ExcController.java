package alexandr.exeptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExcController extends ResponseEntityExceptionHandler {
    @ExceptionHandler({ProblemsWithFileException.class, TextDoesNotFindException.class})
    public ResponseEntity<ExcDto> NotFoundHandle( Exception exception) {
        return new ResponseEntity<ExcDto>(new ExcDto(exception.getLocalizedMessage()), HttpStatus.NOT_FOUND);
    }
}
