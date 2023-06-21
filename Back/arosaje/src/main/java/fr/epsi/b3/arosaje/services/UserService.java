package fr.epsi.b3.arosaje.services;

import fr.epsi.b3.arosaje.bo.User;
import fr.epsi.b3.arosaje.dal.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserDAO userRepository;

    @Autowired
    public UserService(UserDAO userRepository) {
        this.userRepository = userRepository;
    }

    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}