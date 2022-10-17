package self.izouir.modsentesttask.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import self.izouir.modsentesttask.dao.MeetDao;
import self.izouir.modsentesttask.entity.Meet;

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
    public Set<Meet> findAll() {
        Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Meet", Meet.class).getResultStream().collect(Collectors.toSet());
    }

    @Override
    public Meet find(final Long meetId) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Meet.class, meetId);
    }

    @Override
    @Transactional
    public void save(final Meet meet) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(meet);
    }

    @Override
    @Transactional
    public void delete(final Long meetId) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("delete from Meet where meetId =:meetId");
        query.setParameter("meetId", meetId);
        query.executeUpdate();
    }
}
