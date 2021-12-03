package sjsu.edu.cs151.PennySight.exception;

/**
 * This class is the exception class for the controlelr API
 * If the user is not found in the database when the API called
 * This class is thrown as the exception
 * @author PennySight
 */
public class UserNotFoundException extends RuntimeException {
    private String message;
    public UserNotFoundException(String message) {
        super(message);
        this.message = message;
    }
    public UserNotFoundException() {
    }
}
