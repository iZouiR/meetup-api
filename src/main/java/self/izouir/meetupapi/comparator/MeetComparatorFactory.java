package self.izouir.meetupapi.comparator;

import org.springframework.stereotype.Component;
import self.izouir.meetupapi.entity.Meet;

import java.util.Comparator;

@Component
public class MeetComparatorFactory {
    private final MeetComparatorByMeetId byMeetId;
    private final MeetComparatorByTitle byTitle;
    private final MeetComparatorByKeeper byKeeper;
    private final MeetComparatorByDate byDate;

    public MeetComparatorFactory(final MeetComparatorByMeetId byMeetId,
                                 final MeetComparatorByTitle byTitle,
                                 final MeetComparatorByKeeper byKeeper,
                                 final MeetComparatorByDate byDate) {
        this.byMeetId = byMeetId;
        this.byTitle = byTitle;
        this.byKeeper = byKeeper;
        this.byDate = byDate;
    }

    public Comparator<Meet> get(final String comparator) {
        switch (comparator) {
            case "title" -> {
                return byTitle;
            }
            case "keeper" -> {
                return byKeeper;
            }
            case "date" -> {
                return byDate;
            }
            default -> {
                return byMeetId;
            }
        }
    }
}
