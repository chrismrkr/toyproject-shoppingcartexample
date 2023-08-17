package exercise.shoppingcartexample.exceptionHandler.exceptionresult;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class ItemApiExceptionResult {
    private int code;
    private String message;
    private Map<String, String> fieldErrors;
    private Map<String, String> globalErrors;
    public ItemApiExceptionResult(int code, String message) {
        this.code = code;
        this.message = message;
        this.fieldErrors = new HashMap<>();
        this.globalErrors = new HashMap<>();
    }
    public void setFieldError(String field, String errorMessage) {
        this.fieldErrors.put(field, errorMessage);
    }
}
