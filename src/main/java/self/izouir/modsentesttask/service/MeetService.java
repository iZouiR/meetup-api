package self.izouir.modsentesttask.service;

import self.izouir.modsentesttask.entity.Meet;

import java.util.Set;

public interface MeetService {
    Set<Meet> findAll();

    Meet find(Long meetId);

    void save(Meet meet);

    void delete(Long meetId);
}
