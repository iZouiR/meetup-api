package self.izouir.modsentesttask.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

@Entity
@Table(name = "meets")
public class Meet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "meet_id")
    private Long meetId;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "keeper")
    private String keeper;

    @Column(name = "date")
    private Timestamp date;

    @Column(name = "place")
    @Enumerated(EnumType.STRING)
    private Place place;

    public Meet() {
    }

    public Meet(final String title, final String description, final String keeper, final Timestamp date, final Place place) {
        this.title = title;
        this.description = description;
        this.keeper = keeper;
        this.date = date;
        this.place = place;
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
