package fr.epsi.b3.arosaje.controller;

import fr.epsi.b3.arosaje.bo.User;
import fr.epsi.b3.arosaje.dal.UserDAO;
import fr.epsi.b3.arosaje.request.LoginRequest;
import fr.epsi.b3.arosaje.services.AuthenticationService;
import fr.epsi.b3.arosaje.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import static java.lang.Long.parseLong;

@RestController
@RequestMapping("/api")
@CrossOrigin("http://localhost:5173/")
public class UserController {
    @Autowired
    private UserDAO userRepository;
    private final AuthenticationService authenticationService;

    public UserController(UserService userService, AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }


    @GetMapping("/users")
    public List<User> fetchUsers(){
        return userRepository.findAll();
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest) {
        String token = authenticationService.authenticate(loginRequest.getEmail(), loginRequest.getPassword());
        System.out.println(token);
        if (token != null) {
            return ResponseEntity.ok(token);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    @GetMapping("/check-login")
    public ResponseEntity<String> checkLogin(@RequestHeader("Authorization") String token) {
        if (authenticationService.isTokenValid(token)) {
            return ResponseEntity.ok(token);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    /*@PostMapping("/logout")
    public ResponseEntity<?> logout(@RequestHeader("Authorization") String authorizationHeader) {
        // Extract the token from the authorization header
        String token = authorizationHeader.replace("Bearer ", "");

        // Validate the token and check if the user is logged in
        if (authenticationService.isTokenValid(token) && authenticationService.isUserLoggedIn(token)) {
            // Invalidate the token and log out the user
            authenticationService.logoutUser(token);
            return ResponseEntity.ok("Logged out successfully.");
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }*/

    @GetMapping("/users/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable long userId, @RequestHeader("Authorization") String token) {
        if (!authenticationService.isTokenValid(token)) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
        Integer extractedUserId = authenticationService.extractUserIdFromToken(token);
        if (extractedUserId != null && extractedUserId == (userId)) {
            Optional<User> optionalUser = userRepository.findById(userId);
            return optionalUser.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
        } else {
            return ResponseEntity.status(HttpStatus.FORBIDDEN).build();
        }
    }


}