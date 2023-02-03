package fr.epsi.b3.arosaje.controller;

import fr.epsi.b3.arosaje.bo.Plant;
import fr.epsi.b3.arosaje.dal.PlantDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/api")
@CrossOrigin("http://localhost:5173/")
public class PlantController {
    @Autowired
    private PlantDAO plantRepository;

    @GetMapping("/plants")
    public List<Plant> fetchPlants(){
        return plantRepository.findAll();
    }
}
