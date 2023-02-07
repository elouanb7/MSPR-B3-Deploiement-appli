package fr.epsi.b3.arosaje.controller;

import fr.epsi.b3.arosaje.bo.Botanist;
import fr.epsi.b3.arosaje.bo.Plant;
import fr.epsi.b3.arosaje.dal.BotanistDAO;
import fr.epsi.b3.arosaje.dal.CommentaryDAO;
import fr.epsi.b3.arosaje.dal.PlantDAO;
import jakarta.persistence.Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api")
@CrossOrigin("http://localhost:5173/")
public class PlantController {
    @Autowired
    private PlantDAO plantRepository;

    @Autowired
    private BotanistDAO botanistRepository;

    @GetMapping("/plants")
    public List<Plant> fetchPlants(){
        return plantRepository.findAll();
    }

    @PostMapping("/plant/add")
    public Plant addPlant(@RequestBody Plant plant, @RequestParam("botanistId") Long botanistId) {
        Botanist botanist = botanistRepository.findById(botanistId).orElse(null);
        plant.setBotanist(botanist);
        return plantRepository.save(plant);

    }
}
