package fr.epsi.b3.arosaje.controller;

import fr.epsi.b3.arosaje.bo.Ask;
import fr.epsi.b3.arosaje.bo.Commentary;
import fr.epsi.b3.arosaje.bo.Location;
import fr.epsi.b3.arosaje.bo.Plant;
import fr.epsi.b3.arosaje.dal.AskDAO;
import fr.epsi.b3.arosaje.dal.CommentaryDAO;
import fr.epsi.b3.arosaje.dal.LocationDAO;
import fr.epsi.b3.arosaje.dal.PlantDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api/asks")
@CrossOrigin("http://localhost:5173/")
public class AskController {
    @Autowired
    private AskDAO askRepository;

    @Autowired
    private PlantDAO plantRepository;

    @Autowired
    private LocationDAO locationRepository;
    @Autowired
    private CommentaryDAO commentarytRepository;

    @GetMapping("/")
    public List<Ask> fetchPlants(){
        return askRepository.findAll();
    }

    @GetMapping("/{id}")
    public Ask fetchAsk(@PathVariable long id){
        Ask ask = askRepository.findById(id).get();
        Plant plant = plantRepository.findById(ask.getPlant().getId()).get();
        Location location = locationRepository.findById(ask.getLocation().getId()).get();
        List<Commentary> commentaries = commentarytRepository.findByAsk(ask);
        ask.setPlant(plant);
        ask.setLocation(location);
        ask.setCommentaries(commentaries);
        return ask;

    }


}
