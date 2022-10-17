package self.izouir.modsentesttask.exception;

import javax.persistence.EntityNotFoundException;

public class MeetNotFoundException extends EntityNotFoundException {
    public MeetNotFoundException(final String message) {
        super(message);
    }
}
