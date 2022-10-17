package self.izouir.modsentesttask.dao;

import self.izouir.modsentesttask.entity.Meet;

import java.util.Set;

public interface MeetDao {
    Set<Meet> findAll();

    Meet find(Long meetId);

    void save(Meet meet);

    void delete(Long meetId);
}
