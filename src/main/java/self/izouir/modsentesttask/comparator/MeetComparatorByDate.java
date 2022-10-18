package self.izouir.modsentesttask.comparator;

import org.springframework.stereotype.Component;
import self.izouir.modsentesttask.entity.Meet;

import java.util.Comparator;

@Component
public class MeetComparatorByDate implements Comparator<Meet> {
    @Override
    public int compare(final Meet o1, final Meet o2) {
        if (o1.getDate().equals(o2.getDate())) {
            return 0;
        } else if (o1.getDate().after(o2.getDate())) {
            return 1;
        } else {
            return -1;
        }
    }
}
