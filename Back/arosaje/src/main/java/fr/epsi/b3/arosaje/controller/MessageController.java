package fr.epsi.b3.arosaje.controller;

import fr.epsi.b3.arosaje.bo.Message;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import fr.epsi.b3.arosaje.bo.Conversation;
import fr.epsi.b3.arosaje.bo.User;
import fr.epsi.b3.arosaje.dal.ConversationDAO;
import fr.epsi.b3.arosaje.dal.MessageDAO;
import fr.epsi.b3.arosaje.dal.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;

@RestController
@RequestMapping("/api")
@CrossOrigin("http://localhost:5173/")
public class MessageController {

    @Autowired
    private MessageDAO messageRepository;

    @Autowired
    private UserDAO userRepository;

    @Autowired
    private ConversationDAO conversationRepository;

    @GetMapping("messages")
    public List<Message> fetchMessages() {
        return messageRepository.findAll();
    }

    @GetMapping("message/{id}")
    public Message fetchMessage(@PathVariable long id) {
        return messageRepository.findById(id).orElse(null);
    }

    @PostMapping("/message/add")
    public Message addMessage(@RequestBody Message message,
                              @RequestParam("conversationId") Long conversationId,
                              @RequestParam("senderId") Long senderId) {
        Conversation conversation = conversationRepository.findById(conversationId).orElse(null);
        User sender = userRepository.findById(senderId).orElse(null);

        message.setDate(LocalDate.now());
        message.setConv_id(conversation);
        message.setMessage_sender(sender);

        return messageRepository.save(message);
    }

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


