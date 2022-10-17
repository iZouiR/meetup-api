package self.izouir.modsentesttask.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import self.izouir.modsentesttask.dto.MeetDto;
import self.izouir.modsentesttask.service.MeetService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/meets")
public class MeetController {
    private final MeetService meetService;

    @Autowired
    public MeetController(final MeetService meetService) {
        this.meetService = meetService;
    }

    @GetMapping
    public List<MeetDto> findAll() {
        return meetService.findAll();
    }

    @GetMapping("/{meetId}")
    public MeetDto find(@PathVariable("meetId") final Long meetId) {
        return meetService.find(meetId);
    }

    @PostMapping
    public void save(@RequestBody final MeetDto meetDto) {
        meetService.save(meetDto);
    }

    @PutMapping
    public void update(@RequestBody final MeetDto meetDto) {
        meetService.update(meetDto);
    }

    @DeleteMapping("/{meetId}")
    public void delete(@PathVariable("meetId") final Long meetId) {
        meetService.delete(meetId);
    }
}
