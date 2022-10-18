package self.izouir.modsentesttask.service.impl;

import org.springframework.stereotype.Service;
import self.izouir.modsentesttask.comparator.MeetComparatorFactory;
import self.izouir.modsentesttask.dto.MeetDto;
import self.izouir.modsentesttask.entity.Meet;
import self.izouir.modsentesttask.exception.InvalidDateFormatException;
import self.izouir.modsentesttask.mapper.MeetMapper;
import self.izouir.modsentesttask.repository.MeetRepository;
import self.izouir.modsentesttask.service.MeetService;

import javax.persistence.EntityNotFoundException;
import java.sql.Timestamp;
import java.util.List;

@Service
public class MeetServiceImpl implements MeetService {
    private final MeetRepository meetRepository;
    private final MeetMapper meetMapper;
    private final MeetComparatorFactory meetComparatorFactory;

    public MeetServiceImpl(final MeetRepository meetRepository,
                           final MeetMapper meetMapper,
                           final MeetComparatorFactory meetComparatorFactory) {
        this.meetRepository = meetRepository;
        this.meetMapper = meetMapper;
        this.meetComparatorFactory = meetComparatorFactory;
    }

    @Override
    public List<MeetDto> findAll() {
        return meetMapper.mapToDtos(meetRepository.findAll());
    }

    @Override
    public MeetDto find(final Long meetId) {
        final Meet meet = meetRepository.find(meetId).orElseThrow(
                () -> new EntityNotFoundException("Meet with meetId = " + meetId + " was not found"));
        return meetMapper.mapToDto(meet);
    }

    @Override
    public void save(final MeetDto meetDto) {
        meetRepository.save(meetMapper.mapToEntity(meetDto));
    }

    @Override
    public void update(final MeetDto meetDto) {
        try {
            meetRepository.find(meetDto.meetId()).orElseThrow(
                    () -> new EntityNotFoundException("Meet with meetId = " + meetDto.meetId() + " was not found"));
            meetRepository.update(meetMapper.mapToEntity(meetDto));
        } catch (final IllegalArgumentException e) {
            throw new IllegalArgumentException("Field meetId mustn't be null for update");
        }
    }

    @Override
    public void delete(final Long meetId) {
        meetRepository.delete(meetId);
    }

    @Override
    public List<MeetDto> findAllFilteredAndSorted(final String title, final String keeper,
                                                  final String timestamp, final String comparator) {
        try {
            final Timestamp date = (timestamp.isBlank()) ? new Timestamp(0) : Timestamp.valueOf(timestamp);
            final List<Meet> meets = meetRepository.findAllFiltered(title, keeper, date);
            meets.sort(meetComparatorFactory.get(comparator));
            return meetMapper.mapToDtos(meets);
        } catch (final IllegalArgumentException e) {
            throw new InvalidDateFormatException("Date format must be yyyy-mm-dd hh:mm:ss[.fffffffff]");
        }
    }
}
