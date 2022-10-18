package self.izouir.modsentesttask.comparator;

import self.izouir.modsentesttask.entity.Meet;

import java.util.Comparator;

public class MeetComparatorFactory {
    private static final Comparator<Meet> byMeetId = new MeetComparatorByMeetId();
    private static final Comparator<Meet> byTitle = new MeetComparatorByTitle();
    private static final Comparator<Meet> byKeeper = new MeetComparatorByKeeper();
    private static final Comparator<Meet> byDate = new MeetComparatorByDate();

    public static Comparator<Meet> get(final String comparator) {
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

    private MeetComparatorFactory() {
    }
}
