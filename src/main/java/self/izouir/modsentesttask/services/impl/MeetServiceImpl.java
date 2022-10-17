package self.izouir.modsentesttask.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import self.izouir.modsentesttask.daos.MeetDao;
import self.izouir.modsentesttask.entities.Meet;
import self.izouir.modsentesttask.services.MeetService;

import java.util.Set;

@Service
public class MeetServiceImpl implements MeetService {
    private final MeetDao meetDao;

    @Autowired
    public MeetServiceImpl(final MeetDao meetDao) {
        this.meetDao = meetDao;
    }

    @Override
    public Set<Meet> findAllMeets() {
        return meetDao.findAllMeets();
    }

    @Override
    public Meet findMeet(final Long meetId) {
        return meetDao.findMeet(meetId);
    }

    @Override
    public void saveMeet(final Meet meet) {
        meetDao.saveMeet(meet);
    }

    @Override
    public void deleteMeet(final Long meetId) {
        meetDao.deleteMeet(meetId);
    }
}
