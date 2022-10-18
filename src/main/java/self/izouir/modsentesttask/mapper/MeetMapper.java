package self.izouir.modsentesttask.mapper;

import org.springframework.stereotype.Component;
import self.izouir.modsentesttask.dto.MeetDto;
import self.izouir.modsentesttask.entity.Meet;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class MeetMapper {
    public MeetDto mapToDto(final Meet meet) {
        return new MeetDto(meet.getMeetId(), meet.getTitle(), meet.getDescription(), meet.getKeeper(), meet.getDate(), meet.getPlace());
    }

    public Meet mapToEntity(final MeetDto meetDto) {
        return new Meet(meetDto.meetId(), meetDto.title(), meetDto.description(), meetDto.keeper(), meetDto.date(), meetDto.place());
    }

    public List<MeetDto> mapToDtos(final List<Meet> meets) {
        return meets.stream().map(this::mapToDto).collect(Collectors.toList());
    }
}
