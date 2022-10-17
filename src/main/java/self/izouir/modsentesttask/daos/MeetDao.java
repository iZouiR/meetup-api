package self.izouir.modsentesttask.daos;

import self.izouir.modsentesttask.entities.Meet;

import java.util.Set;

public interface MeetDao {
    Set<Meet> findAllMeets();

    Meet findMeet(Long meetId);

    void saveMeet (Meet meet);

    void deleteMeet(Long meetId);
}
