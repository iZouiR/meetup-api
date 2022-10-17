package self.izouir.modsentesttask.repository;

import self.izouir.modsentesttask.entity.Meet;

import java.sql.Timestamp;
import java.util.List;
import java.util.Optional;

public interface MeetRepository {
    List<Meet> findAll();

    Optional<Meet> find(Long meetId);

    void save(Meet meet);

    void update(Meet meet);

    void delete(Long meetId);

    List<Meet> findAllFilter(String title, String keeper, Timestamp date);
}
