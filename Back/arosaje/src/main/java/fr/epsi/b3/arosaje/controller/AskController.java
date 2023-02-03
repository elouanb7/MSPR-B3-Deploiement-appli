package fr.epsi.b3.arosaje.controller;

import fr.epsi.b3.arosaje.bo.Ask;
import fr.epsi.b3.arosaje.dal.AskDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/api")
@CrossOrigin("http://localhost:5173/")
public class AskController {
    @Autowired
    private AskDAO askRepository;

    @GetMapping("/asks")
    public List<Ask> fetchPlants(){
        return askRepository.findAll();
    }
}
