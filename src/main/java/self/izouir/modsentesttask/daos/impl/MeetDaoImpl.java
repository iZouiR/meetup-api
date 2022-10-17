package self.izouir.modsentesttask.daos.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import self.izouir.modsentesttask.daos.MeetDao;
import self.izouir.modsentesttask.entities.Meet;

import javax.persistence.Query;
import java.util.Set;
import java.util.stream.Collectors;

@Repository
public class MeetDaoImpl implements MeetDao {
    private final SessionFactory sessionFactory;

    @Autowired
    public MeetDaoImpl(final SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public Set<Meet> getAllMeets() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("select from Meet", Meet.class).getResultStream().collect(Collectors.toSet());
    }

    @Override
    public Meet getMeet(final Long meetId) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Meet.class, meetId);
    }

    @Override
    public void saveMeet(final Meet meet) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(meet);
    }

    @Override
    public void deleteMeet(final Long meetId) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("delete from Meet where meetId =:meetId");
        query.setParameter("meetId", meetId);
        query.executeUpdate();
    }
}
