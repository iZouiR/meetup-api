package self.izouir.modsentesttask.dao;

import self.izouir.modsentesttask.entity.Meet;

import java.util.List;
import java.util.Optional;

public interface MeetDao {
    List<Meet> findAll();

    Optional<Meet> find(Long meetId);

    void save(Meet meet);

    void update(Meet meet);

    void delete(Long meetId);
}
