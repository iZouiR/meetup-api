package self.izouir.modsentesttask.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import self.izouir.modsentesttask.dao.MeetDao;
import self.izouir.modsentesttask.entity.Meet;
import self.izouir.modsentesttask.service.MeetService;

import java.util.Set;

@Service
public class MeetServiceImpl implements MeetService {
    private final MeetDao meetDao;

    @Autowired
    public MeetServiceImpl(final MeetDao meetDao) {
        this.meetDao = meetDao;
    }

    @Override
    public Set<Meet> findAll() {
        return meetDao.findAll();
    }

    @Override
    public Meet find(final Long meetId) {
        return meetDao.find(meetId);
    }

    @Override
    public void save(final Meet meet) {
        meetDao.save(meet);
    }

    @Override
    public void delete(final Long meetId) {
        meetDao.delete(meetId);
    }
}
