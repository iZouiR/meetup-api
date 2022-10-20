package self.izouir.modsentesttask.service;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import self.izouir.modsentesttask.comparator.MeetComparatorByDate;
import self.izouir.modsentesttask.comparator.MeetComparatorByKeeper;
import self.izouir.modsentesttask.comparator.MeetComparatorByMeetId;
import self.izouir.modsentesttask.comparator.MeetComparatorByTitle;
import self.izouir.modsentesttask.comparator.MeetComparatorFactory;
import self.izouir.modsentesttask.dto.MeetDto;
import self.izouir.modsentesttask.entity.Meet;
import self.izouir.modsentesttask.entity.Place;
import self.izouir.modsentesttask.exception.InvalidDateFormatException;
import self.izouir.modsentesttask.mapper.MeetMapper;
import self.izouir.modsentesttask.repository.MeetRepository;
import self.izouir.modsentesttask.service.impl.MeetServiceImpl;

import javax.persistence.EntityNotFoundException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class MeetServiceImplTest {
    static List<Meet> meets;
    static List<MeetDto> meetDtos;
    static MeetDto nullMeetIdMeetDto;
    static MeetDto equal4MeetIdMeetDto;
    static MeetDto equalMinus1MeetIdMeetDto;

    @BeforeAll
    static void beforeAll() {
        meets = new ArrayList<>();
        meets.add(new Meet(1L, "c", "a", "b", new Timestamp(1), Place.EUROPE));
        meets.add(new Meet(2L, "a", "b", "c", new Timestamp(2), Place.ASIA));
        meets.add(new Meet(3L, "b", "c", "a", new Timestamp(3), Place.AFRICA));

        meetDtos = new ArrayList<>();
        meetDtos.add(new MeetDto(1L, "c", "a", "b", new Timestamp(1), Place.EUROPE));
        meetDtos.add(new MeetDto(2L, "a", "b", "c", new Timestamp(2), Place.ASIA));
        meetDtos.add(new MeetDto(3L, "b", "c", "a", new Timestamp(3), Place.AFRICA));

        nullMeetIdMeetDto = new MeetDto(null, "title", "description", "keeper", new Timestamp(0), Place.EUROPE);

        equal4MeetIdMeetDto = new MeetDto(4L, "title", "description", "keeper", new Timestamp(0), Place.EUROPE);
        equalMinus1MeetIdMeetDto = new MeetDto(-1L, "title", "description", "keeper", new Timestamp(0), Place.EUROPE);
    }

    @Mock
    MeetRepository meetRepository;
    @Mock
    MeetMapper meetMapper;
    @Mock
    MeetComparatorFactory meetComparatorFactory;

    @InjectMocks
    MeetServiceImpl meetService;

    @Test
    public void findAllShouldPass() {
        when(meetRepository.findAll())
                .thenReturn(new ArrayList<>());
        when(meetMapper.mapToDtos(new ArrayList<>()))
                .thenReturn(new ArrayList<>());
        assertEquals(0,
                meetService.findAll().size());

        when(meetRepository.findAll())
                .thenReturn(meets);
        when(meetMapper.mapToDtos(meets))
                .thenReturn(meetDtos);
        assertEquals(3,
                meetService.findAll().size());
    }

    @Test
    public void findShouldPass() {
        when(meetRepository.find(null))
                .thenReturn(Optional.empty());
        assertThrows(EntityNotFoundException.class,
                () -> meetService.find(null));

        when(meetRepository.find(1L))
                .thenReturn(Optional.of(meets.get(0)));
        when(meetMapper.mapToDto(meets.get(0)))
                .thenReturn(meetDtos.get(0));
        assertEquals(meetDtos.get(0),
                meetService.find(1L));

        when(meetRepository.find(4L))
                .thenReturn(Optional.empty());
        assertThrows(EntityNotFoundException.class,
                () -> meetService.find(4L));

        when(meetRepository.find(-1L))
                .thenReturn(Optional.empty());
        assertThrows(EntityNotFoundException.class,
                () -> meetService.find(-1L));
    }

    @Test
    public void saveShouldPass() {
        when(meetMapper.mapToEntity(meetDtos.get(0)))
                .thenReturn(meets.get(0));
        assertDoesNotThrow(() -> meetService.save(meetDtos.get(0)));
    }

    @Test
    public void updateShouldPass() {
        when(meetRepository.find(null))
                .thenReturn(Optional.empty());
        assertThrows(EntityNotFoundException.class,
                () -> meetService.update(nullMeetIdMeetDto));

        when(meetRepository.find(1L))
                .thenReturn(Optional.of(meets.get(0)));
        assertDoesNotThrow(() -> meetService.update(meetDtos.get(0)));

        when(meetRepository.find(4L))
                .thenReturn(Optional.empty());
        assertThrows(EntityNotFoundException.class,
                () -> meetService.update(equal4MeetIdMeetDto));

        when(meetRepository.find(-1L))
                .thenReturn(Optional.empty());
        assertThrows(EntityNotFoundException.class,
                () -> meetService.update(equalMinus1MeetIdMeetDto));
    }

    @Test
    public void deleteShouldPass() {
        assertDoesNotThrow(() -> meetService.delete(null));
        assertDoesNotThrow(() -> meetService.delete(1L));
        assertDoesNotThrow(() -> meetService.delete(4L));
        assertDoesNotThrow(() -> meetService.delete(-1L));
    }

    @Test
    public void findAllFilteredAndSortedShouldPass() {
        assertThrows(InvalidDateFormatException.class, () -> meetService.findAllFilteredAndSorted("", "", "error", ""));

        when(meetRepository.findAllFiltered("", "", new Timestamp(0)))
                .thenReturn(meets);

        when(meetMapper.mapToDtos(meets.stream().sorted(new MeetComparatorByTitle()).collect(Collectors.toList())))
                .thenReturn(new MeetMapper().mapToDtos(meets.stream().sorted(new MeetComparatorByTitle()).collect(Collectors.toList())));
        when(meetComparatorFactory.get("title"))
                .thenReturn(new MeetComparatorByTitle());
        assertEquals(meetMapper.mapToDtos(meets.stream().sorted(new MeetComparatorByTitle()).collect(Collectors.toList())),
                meetService.findAllFilteredAndSorted("", "", "", "title"));

        when(meetMapper.mapToDtos(meets.stream().sorted(new MeetComparatorByKeeper()).collect(Collectors.toList())))
                .thenReturn(new MeetMapper().mapToDtos(meets.stream().sorted(new MeetComparatorByKeeper()).collect(Collectors.toList())));
        when(meetComparatorFactory.get("keeper"))
                .thenReturn(new MeetComparatorByKeeper());
        assertEquals(meetMapper.mapToDtos(meets.stream().sorted(new MeetComparatorByKeeper()).collect(Collectors.toList())),
                meetService.findAllFilteredAndSorted("", "", "", "keeper"));

        when(meetMapper.mapToDtos(meets.stream().sorted(new MeetComparatorByDate()).collect(Collectors.toList())))
                .thenReturn(new MeetMapper().mapToDtos(meets.stream().sorted(new MeetComparatorByDate()).collect(Collectors.toList())));
        when(meetComparatorFactory.get("date"))
                .thenReturn(new MeetComparatorByDate());
        assertEquals(meetMapper.mapToDtos(meets.stream().sorted(new MeetComparatorByDate()).collect(Collectors.toList())),
                meetService.findAllFilteredAndSorted("", "", "", "date"));

        when(meetMapper.mapToDtos(meets.stream().sorted(new MeetComparatorByMeetId()).collect(Collectors.toList())))
                .thenReturn(new MeetMapper().mapToDtos(meets.stream().sorted(new MeetComparatorByMeetId()).collect(Collectors.toList())));
        when(meetComparatorFactory.get(""))
                .thenReturn(new MeetComparatorByMeetId());
        assertEquals(meetDtos,
                meetService.findAllFilteredAndSorted("", "", "", ""));
    }
}
