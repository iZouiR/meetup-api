package self.izouir.modsentesttask.service;

import self.izouir.modsentesttask.entity.Meet;

import java.util.Set;

public interface MeetService {
    Set<Meet> findAllMeets();

    Meet findMeet(Long meetId);

    void saveMeet(Meet meet);

    void deleteMeet(Long meetId);
}
