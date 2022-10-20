package self.izouir.meetupapi.dto;

import java.sql.Timestamp;

public record ErrorDto(int statusCode,
                       String message,
                       Timestamp timestamp) {
}
