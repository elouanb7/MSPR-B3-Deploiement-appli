package fr.epsi.b3.arosaje.controller;

import fr.epsi.b3.arosaje.bo.Message;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/messages")
public class Messagecontroller {

    private List<Message> messages = new ArrayList<>();

    @GetMapping("/new")
    public List<Message> getNewMessages() {
        // Logique pour récupérer les nouveaux messages non lus
        List<Message> unreadMessages = messages.stream()
                .filter(message -> !message.isRead()) // Filtrer les messages non lus
                .collect(Collectors.toList());
        return unreadMessages;
    }
}


