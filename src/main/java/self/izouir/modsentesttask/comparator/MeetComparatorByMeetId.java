package self.izouir.modsentesttask.comparator;

import self.izouir.modsentesttask.entity.Meet;

import java.util.Comparator;
import java.util.Objects;

public class MeetComparatorByMeetId implements Comparator<Meet> {
    @Override
    public int compare(final Meet o1, final Meet o2) {
        if (Objects.equals(o1.getMeetId(), o2.getMeetId())) {
            return 0;
        } else if (o1.getMeetId() > o2.getMeetId()) {
            return 1;
        } else {
            return -1;
        }
    }
}
