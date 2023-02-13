package fr.epsi.b3.arosaje.controller;

import fr.epsi.b3.arosaje.bo.Ask;
import fr.epsi.b3.arosaje.bo.Location;
import fr.epsi.b3.arosaje.bo.User;
import fr.epsi.b3.arosaje.dal.LocationDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin("http://localhost:5173/")
public class LocationController {

    @Autowired
    private LocationDAO locationRepository;

    @PostMapping("/location/add")
    public Location addLocation(@RequestBody Location location) {
        return locationRepository.save(location);
    }
}
