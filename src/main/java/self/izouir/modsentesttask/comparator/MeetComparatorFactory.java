package self.izouir.modsentesttask.comparator;

import org.springframework.stereotype.Component;
import self.izouir.modsentesttask.entity.Meet;

import java.util.Comparator;

@Component
public record MeetComparatorFactory(MeetComparatorByMeetId byMeetId,
                                    MeetComparatorByTitle byTitle,
                                    MeetComparatorByKeeper byKeeper,
                                    MeetComparatorByDate byDate) {
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
