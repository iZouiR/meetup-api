package self.izouir.modsentesttask.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import self.izouir.modsentesttask.dao.MeetDao;
import self.izouir.modsentesttask.dto.MeetDto;
import self.izouir.modsentesttask.entity.Meet;
import self.izouir.modsentesttask.exception.MeetExistsException;
import self.izouir.modsentesttask.exception.MeetNotFoundException;
import self.izouir.modsentesttask.mapper.MeetMapper;
import self.izouir.modsentesttask.service.MeetService;

import java.util.List;

@Service
public class MeetServiceImpl implements MeetService {
    private final MeetDao meetDao;
    private final MeetMapper meetMapper;

    @Autowired
    public MeetServiceImpl(final MeetDao meetDao,
                           final MeetMapper meetMapper) {
        this.meetDao = meetDao;
        this.meetMapper = meetMapper;
    }

    @Override
    public List<MeetDto> findAll() {
        return meetMapper.mapToDtos(meetDao.findAll());
    }

    @Override
    public MeetDto find(final Long meetId) {
        final Meet meet = meetDao.find(meetId).orElseThrow(
                () -> new MeetNotFoundException("Meet with meetId = " + meetId + " was not found"));
        return meetMapper.mapToDto(meet);
    }

    @Override
    public void save(final MeetDto meetDto) {
        meetDao.find(meetDto.getMeetId()).ifPresent(
                meet -> {throw new MeetExistsException("Meet with meetId = " + meetDto.getMeetId() + " already exists");});
        meetDao.save(meetMapper.mapToEntity(meetDto));
    }

    @Override
    public void update(final MeetDto meetDto) {
        meetDao.find(meetDto.getMeetId()).orElseThrow(
                () -> new MeetNotFoundException("Meet with meetId = " + meetDto.getMeetId() + " was not found"));
        meetDao.update(meetMapper.mapToEntity(meetDto));
    }

    @Override
    public void delete(final Long meetId) {
        meetDao.delete(meetId);
    }
}
