package alexandr.exeptions;

public class ProblemsWithFileException extends RuntimeException {
    public ProblemsWithFileException(String message) {
        super(message);
    }
}
