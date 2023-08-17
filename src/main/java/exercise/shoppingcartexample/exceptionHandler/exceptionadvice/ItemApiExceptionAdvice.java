package exercise.shoppingcartexample.exceptionHandler.exceptionadvice;


import exercise.shoppingcartexample.controller.ItemController;
import exercise.shoppingcartexample.exceptionHandler.exceptionresult.ItemApiExceptionResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice(assignableTypes = {ItemController.class})
public class ItemApiExceptionAdvice {
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ItemApiExceptionResult methodArgumentNotValidException(MethodArgumentNotValidException exception) {
        ItemApiExceptionResult itemApiExceptionResult = new ItemApiExceptionResult(HttpStatus.BAD_REQUEST.value(), exception.getMessage());
        exception.getFieldErrors().stream().forEach(fieldError -> {
            itemApiExceptionResult.setFieldError(
                    fieldError.getField(),
                    fieldError.getDefaultMessage()
            );
        });
        return itemApiExceptionResult;
    }

}
