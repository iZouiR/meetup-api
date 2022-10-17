package self.izouir.modsentesttask.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import self.izouir.modsentesttask.entities.Meet;
import self.izouir.modsentesttask.services.MeetService;

import java.util.Set;

@RestController
@RequestMapping("api/v1/meets")
public class MeetController {
    private final MeetService meetService;

    @Autowired
    public MeetController(final MeetService meetService) {
        this.meetService = meetService;
    }

    @GetMapping
    public Set<Meet> findAllMeets() {
        return meetService.findAllMeets();
    }

    @GetMapping("/{meetId}")
    public Meet findMeet(@PathVariable("meetId") Long meetId) {
        return meetService.findMeet(meetId);
    }

    @PostMapping
    public void saveMeet(@RequestBody Meet meet) {
        meetService.saveMeet(meet);
    }

    @PutMapping
    public void editMeet(@RequestBody Meet meet) {
        meetService.saveMeet(meet);
    }

    @DeleteMapping("/{meetId}")
    public void deleteMeet(@PathVariable("meetId") Long meetId) {
        meetService.deleteMeet(meetId);
    }
}
