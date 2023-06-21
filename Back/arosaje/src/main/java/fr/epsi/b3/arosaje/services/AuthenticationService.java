package fr.epsi.b3.arosaje.services;

import fr.epsi.b3.arosaje.bo.User;
import fr.epsi.b3.arosaje.dal.UserDAO;
import fr.epsi.b3.arosaje.utils.JwtUtils;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthenticationService {
    private final UserDAO userRepository;
    private final JwtUtils jwtUtils;

    public AuthenticationService(UserDAO userRepository, JwtUtils jwtUtils) {
        this.userRepository = userRepository;
        this.jwtUtils = jwtUtils;
    }

    public String authenticate(String username, String password) {
        Optional<User> optionalUser = Optional.ofNullable(userRepository.findByUsername(username));
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            if (user.getPassword().equals(password)) {
                return jwtUtils.createJwtToken(user);
            }
        }
        return null;
    }

    public boolean isTokenValid(String token) {
        return jwtUtils.verifyJwtToken(token);
    }

    public String extractUserIdFromToken(String token) {
        return jwtUtils.extractUserIdFromToken(token);
    }
}
