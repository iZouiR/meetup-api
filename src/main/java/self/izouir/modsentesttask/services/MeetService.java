package self.izouir.modsentesttask.services;

import self.izouir.modsentesttask.entities.Meet;

import java.util.Set;

public interface MeetService {
    Set<Meet> getAllMeets();

    Meet getMeet(Long meetId);

    void saveMeet(Meet meet);

    void deleteMeet(Long meetId);
}
