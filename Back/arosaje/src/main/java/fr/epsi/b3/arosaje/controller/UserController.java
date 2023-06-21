package fr.epsi.b3.arosaje.controller;

import fr.epsi.b3.arosaje.bo.User;
import fr.epsi.b3.arosaje.dal.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api")
@CrossOrigin("http://localhost:5173/")
public class UserController {
    @Autowired
    private UserDAO userRepository;

    @GetMapping("/users")
    public List<User> fetchUsers(){
        return userRepository.findAll();
    }


}