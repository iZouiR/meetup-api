package self.izouir.modsentesttask.dto;

import java.sql.Timestamp;

public record ErrorDto(int statusCode,
                       String message,
                       Timestamp timestamp) {
}
