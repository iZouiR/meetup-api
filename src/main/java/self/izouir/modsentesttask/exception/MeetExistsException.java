package self.izouir.modsentesttask.exception;

import javax.persistence.EntityExistsException;

public class MeetExistsException extends EntityExistsException {
    public MeetExistsException(final String message) {
        super(message);
    }
}
