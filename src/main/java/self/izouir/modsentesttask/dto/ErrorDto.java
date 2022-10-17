package self.izouir.modsentesttask.dto;

import java.sql.Timestamp;

public class ErrorDto {
    private int statusCode;
    private String message;
    private Timestamp timestamp;

    public ErrorDto(final int statusCode, final String message, final Timestamp timestamp) {
        this.statusCode = statusCode;
        this.message = message;
        this.timestamp = timestamp;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(final int statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(final String message) {
        this.message = message;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(final Timestamp timestamp) {
        this.timestamp = timestamp;
    }
}
