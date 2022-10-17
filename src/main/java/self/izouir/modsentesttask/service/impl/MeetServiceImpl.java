package self.izouir.modsentesttask.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import self.izouir.modsentesttask.converter.StringToTimestampConverter;
import self.izouir.modsentesttask.dto.MeetDto;
import self.izouir.modsentesttask.entity.Meet;
import self.izouir.modsentesttask.exception.MeetNotFoundException;
import self.izouir.modsentesttask.mapper.MeetMapper;
import self.izouir.modsentesttask.repository.MeetRepository;
import self.izouir.modsentesttask.service.MeetService;

import java.sql.Timestamp;
import java.util.List;

@Service
public class MeetServiceImpl implements MeetService {
    private final MeetRepository meetRepository;
    private final MeetMapper meetMapper;
    private final StringToTimestampConverter stringToTimestampConverter;

    @Autowired
    public MeetServiceImpl(final MeetRepository meetRepository,
                           final MeetMapper meetMapper,
                           final StringToTimestampConverter stringToTimestampConverter) {
        this.meetRepository = meetRepository;
        this.meetMapper = meetMapper;
        this.stringToTimestampConverter = stringToTimestampConverter;
    }

    @Override
    public List<MeetDto> findAll() {
        return meetMapper.mapToDtos(meetRepository.findAll());
    }

    @Override
    public MeetDto find(final Long meetId) {
        final Meet meet = meetRepository.find(meetId).orElseThrow(
                () -> new MeetNotFoundException("Meet with meetId = " + meetId + " was not found"));
        return meetMapper.mapToDto(meet);
    }

    @Override
    public void save(final MeetDto meetDto) {
        meetRepository.save(meetMapper.mapToEntity(meetDto));
    }

    @Override
    public void update(final MeetDto meetDto) {
        meetRepository.find(meetDto.meetId()).orElseThrow(
                () -> new MeetNotFoundException("Meet with meetId = " + meetDto.meetId() + " was not found"));
        meetRepository.update(meetMapper.mapToEntity(meetDto));
    }

    @Override
    public void delete(final Long meetId) {
        meetRepository.delete(meetId);
    }

    @Override
    public List<MeetDto> findAllFilterAndSorter(String title, String keeper, final String stringDate, String sortMode) {
        title = (title == null) ? "" : title;
        keeper = (keeper == null) ? "" : keeper;
        final Timestamp date = (stringDate == null || stringDate.isBlank()) ?
                new Timestamp(0) : stringToTimestampConverter.convert(stringDate);
        sortMode = (sortMode == null) ? "" : sortMode;
        final List<Meet> meets = meetRepository.findAllFilter(title, keeper, date);
        switch (sortMode) {
            case "title" -> meets.sort((o1, o2) -> {
                if (o1.getTitle().equals(o2.getTitle())) {
                    return 0;
                } else if (o1.getTitle().compareTo(o2.getTitle()) > 0) {
                    return 1;
                } else {
                    return -1;
                }
            });
            case "keeper" -> meets.sort((o1, o2) -> {
                if (o1.getKeeper().equals(o2.getKeeper())) {
                    return 0;
                } else if (o1.getKeeper().compareTo(o2.getKeeper()) > 0) {
                    return 1;
                } else {
                    return -1;
                }
            });
            case "date" -> meets.sort((o1, o2) -> {
                if (o1.getDate().equals(o2.getDate())) {
                    return 0;
                } else if (o1.getDate().after(o2.getDate())) {
                    return 1;
                } else {
                    return -1;
                }
            });
        }
        return meetMapper.mapToDtos(meets);
    }
}
