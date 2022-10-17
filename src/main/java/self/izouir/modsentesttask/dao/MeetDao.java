package self.izouir.modsentesttask.dao;

import self.izouir.modsentesttask.entity.Meet;

import java.util.Set;

public interface MeetDao {
    Set<Meet> findAllMeets();

    Meet findMeet(Long meetId);

    void saveMeet (Meet meet);

    void deleteMeet(Long meetId);
}
