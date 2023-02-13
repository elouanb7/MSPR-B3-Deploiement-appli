package fr.epsi.b3.arosaje.controller;

import fr.epsi.b3.arosaje.bo.*;
import fr.epsi.b3.arosaje.dal.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api")
@CrossOrigin("http://localhost:5173/")
public class AskController {
    @Autowired
    private AskDAO askRepository;

    @Autowired
    private PlantDAO plantRepository;

    @Autowired
    private LocationDAO locationRepository;
    @Autowired
    private CommentaryDAO commentaryRepository;

    @Autowired
    private UserDAO userRepository;

    @GetMapping("asks")
    public List<Ask> fetchAsk(){
        return askRepository.findAll();
    }

    @GetMapping("ask/{id}")
    public Ask fetchAsk(@PathVariable long id){
        Ask ask = askRepository.findById(id).get();
        Plant plant = plantRepository.findById(ask.getPlant().getId()).get();
        Location location = locationRepository.findById(ask.getLocation().getId()).get();
        List<Commentary> commentaries = commentaryRepository.findByAsk(ask);
        ask.setPlant(plant);
        ask.setLocation(location);
        ask.setCommentaries(commentaries);
        return ask;
    }

    @PostMapping("/ask/add")
    public Ask addAsk(@RequestBody Ask ask, @RequestParam("ownerId") Long ownerId) {
        User owner = userRepository.findById(ownerId).orElse(null);
        Location location = ask.getLocation();
        locationRepository.save(location);
        ask.setLocation(location);
        ask.setOwner(owner);
        return askRepository.save(ask);
    }


}
