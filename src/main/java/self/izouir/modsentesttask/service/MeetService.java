package self.izouir.modsentesttask.service;

import self.izouir.modsentesttask.dto.MeetDto;

import java.util.List;

public interface MeetService {
    List<MeetDto> findAll();

    MeetDto find(Long meetId);

    void save(MeetDto meetDto);

    void update(MeetDto meetDto);

    void delete(Long meetId);

    List<MeetDto> findAllFilterAndSorter(String title, String keeper, String stringDate, String sortMode);
}
