package self.izouir.modsentesttask.dto;

import self.izouir.modsentesttask.entity.Place;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

public record MeetDto(Long meetId,
                      @NotNull
                      @NotBlank
                      String title,
                      String description,
                      @NotNull
                      @NotBlank
                      String keeper,
                      @NotNull
                      Timestamp date,
                      @NotNull
                      Place place) {
}
