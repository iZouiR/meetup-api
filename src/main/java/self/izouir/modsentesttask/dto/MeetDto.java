package self.izouir.modsentesttask.dto;

import self.izouir.modsentesttask.entity.Place;

import java.sql.Timestamp;

public record MeetDto(Long meetId, String title, String description, String keeper, Timestamp date, Place place) {
}
