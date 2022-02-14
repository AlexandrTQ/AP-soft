package alexandr.exeptions;

public class TextDoesNotFindException extends RuntimeException {
    public TextDoesNotFindException(String message) {
        super(message);
    }
}
