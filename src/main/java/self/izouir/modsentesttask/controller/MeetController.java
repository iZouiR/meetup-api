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
import self.izouir.modsentesttask.entity.Meet;
import self.izouir.modsentesttask.service.MeetService;

import java.util.Set;

@RestController
@RequestMapping("/api/v1/meets")
public class MeetController {
    private final MeetService meetService;

    @Autowired
    public MeetController(final MeetService meetService) {
        this.meetService = meetService;
    }

    @GetMapping
    public Set<Meet> findAll() {
        return meetService.findAll();
    }

    @GetMapping("/{meetId}")
    public Meet find(@PathVariable("meetId") final Long meetId) {
        return meetService.find(meetId);
    }

    @PostMapping
    public void save(@RequestBody final Meet meet) {
        meetService.save(meet);
    }

    @PutMapping
    public void update(@RequestBody final Meet meet) {
        meetService.save(meet);
    }

    @DeleteMapping("/{meetId}")
    public void delete(@PathVariable("meetId") final Long meetId) {
        meetService.delete(meetId);
    }
}
