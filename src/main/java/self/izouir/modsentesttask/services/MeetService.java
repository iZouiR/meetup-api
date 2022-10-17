package self.izouir.modsentesttask.services;

import self.izouir.modsentesttask.entities.Meet;

import java.util.Set;

public interface MeetService {
    Set<Meet> findAllMeets();

    Meet findMeet(Long meetId);

    void saveMeet(Meet meet);

    void deleteMeet(Long meetId);
}
