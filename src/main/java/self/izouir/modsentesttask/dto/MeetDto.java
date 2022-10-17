package self.izouir.modsentesttask.dto;

import self.izouir.modsentesttask.entity.Place;

import java.sql.Timestamp;

public class MeetDto {
    private Long meetId;
    private String title;
    private String description;
    private String keeper;
    private Timestamp date;
    private Place place;

    public MeetDto() {
    }

    public Long getMeetId() {
        return meetId;
    }

    public void setMeetId(final Long meetId) {
        this.meetId = meetId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(final String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public String getKeeper() {
        return keeper;
    }

    public void setKeeper(final String keeper) {
        this.keeper = keeper;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(final Timestamp date) {
        this.date = date;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(final Place place) {
        this.place = place;
    }
}
