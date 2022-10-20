package self.izouir.meetupapi.controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import self.izouir.meetupapi.dto.MeetDto;
import self.izouir.meetupapi.service.MeetService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/meets")
public record MeetController(MeetService meetService) {
    @GetMapping
    public List<MeetDto> findAll() {
        return meetService.findAll();
    }

    @GetMapping("/{meetId}")
    public MeetDto find(@PathVariable("meetId") final Long meetId) {
        return meetService.find(meetId);
    }

    @PostMapping
    public void save(@Validated @RequestBody final MeetDto meetDto) {
        meetService.save(meetDto);
    }

    @PutMapping
    public void update(@Validated @RequestBody final MeetDto meetDto) {
        meetService.update(meetDto);
    }

    @DeleteMapping("/{meetId}")
    public void delete(@PathVariable("meetId") final Long meetId) {
        meetService.delete(meetId);
    }

    @GetMapping("/filter-sort")
    public List<MeetDto> findAllFilteredAndSorted(@RequestParam(value = "title", required = false, defaultValue = "") final String title,
                                                  @RequestParam(value = "keeper", required = false, defaultValue = "") final String keeper,
                                                  @RequestParam(value = "date", required = false, defaultValue = "") final String timestamp,
                                                  @RequestParam(value = "comparator", required = false, defaultValue = "") final String comparator) {
        return meetService.findAllFilteredAndSorted(title, keeper, timestamp, comparator);
    }
}
