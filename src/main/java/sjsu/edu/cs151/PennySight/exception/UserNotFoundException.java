package sjsu.edu.cs151.PennySight.exception;

public class UserNotFoundException extends RuntimeException {
    private String message;
    public UserNotFoundException(String message) {
        super(message);
        this.message = message;
    }
    public UserNotFoundException() {
    }
}
