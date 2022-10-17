package self.izouir.modsentesttask.daos;

import self.izouir.modsentesttask.entities.Meet;

import java.util.Set;

public interface MeetDao {
    Set<Meet> getAllMeets();

    Meet getMeet(Long meetId);

    void saveMeet (Meet meet);

    void deleteMeet(Long meetId);
}
