package self.izouir.meetupapi.exception;

public class InvalidDateFormatException extends IllegalArgumentException {
    public InvalidDateFormatException(final String message) {
        super(message);
    }
}
