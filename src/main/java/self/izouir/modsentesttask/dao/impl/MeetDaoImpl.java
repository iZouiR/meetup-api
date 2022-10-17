package self.izouir.modsentesttask.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import self.izouir.modsentesttask.dao.MeetDao;
import self.izouir.modsentesttask.entity.Meet;

import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

@Repository
public class MeetDaoImpl implements MeetDao {
    private final SessionFactory sessionFactory;

    @Autowired
    public MeetDaoImpl(final SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<Meet> findAll() {
        final Session session = sessionFactory.getCurrentSession();
        return session.createQuery("from Meet", Meet.class).getResultList();
    }

    @Override
    public Optional<Meet> find(final Long meetId) {
        final Session session = sessionFactory.getCurrentSession();
        return Optional.ofNullable(session.find(Meet.class, meetId));
    }

    @Override
    public void save(final Meet meet) {
        final Session session = sessionFactory.getCurrentSession();
        session.save(meet);
    }

    @Override
    @Transactional
    public void update(final Meet meet) {
        final Session session = sessionFactory.getCurrentSession();
        session.clear();
        session.update(meet);
    }

    @Override
    @Transactional
    public void delete(final Long meetId) {
        final Session session = sessionFactory.getCurrentSession();
        final Query query = session.createQuery("delete from Meet where meetId =:meetId");
        query.setParameter("meetId", meetId);
        query.executeUpdate();
    }
}
