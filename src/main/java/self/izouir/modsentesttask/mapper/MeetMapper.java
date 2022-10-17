package self.izouir.modsentesttask.mapper;

import org.springframework.stereotype.Component;
import self.izouir.modsentesttask.dto.MeetDto;
import self.izouir.modsentesttask.entity.Meet;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class MeetMapper {
    public MeetDto mapToDto(final Meet meet) {
        final MeetDto meetDto = new MeetDto();
        meetDto.setMeetId(meet.getMeetId());
        meetDto.setTitle(meet.getTitle());
        meetDto.setDescription(meet.getDescription());
        meetDto.setKeeper(meet.getKeeper());
        meetDto.setDate(meet.getDate());
        meetDto.setPlace(meet.getPlace());
        return meetDto;
    }

    public Meet mapToEntity(final MeetDto meetDto) {
        final Meet meet = new Meet();
        meet.setMeetId(meetDto.getMeetId());
        meet.setTitle(meetDto.getTitle());
        meet.setDescription(meetDto.getDescription());
        meet.setKeeper(meetDto.getKeeper());
        meet.setDate(meetDto.getDate());
        meet.setPlace(meetDto.getPlace());
        return meet;
    }

    public List<MeetDto> mapToDtos(final List<Meet> meets) {
        return meets.stream().map(this::mapToDto).collect(Collectors.toList());
    }
}
