package self.izouir.modsentesttask.comparator;

import org.springframework.stereotype.Component;
import self.izouir.modsentesttask.entity.Meet;

import java.util.Comparator;

@Component
public class MeetComparatorByTitle implements Comparator<Meet> {
    @Override
    public int compare(final Meet o1, final Meet o2) {
        if (o1.getTitle().equals(o2.getTitle())) {
            return 0;
        } else if (o1.getTitle().compareTo(o2.getTitle()) > 0) {
            return 1;
        } else {
            return -1;
        }
    }
}
