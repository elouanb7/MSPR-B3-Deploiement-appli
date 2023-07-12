package fr.epsi.b3.arosaje.controller;

import fr.epsi.b3.arosaje.bo.Conversation;
import fr.epsi.b3.arosaje.bo.Message;
import fr.epsi.b3.arosaje.bo.User;
import fr.epsi.b3.arosaje.dal.ConversationDAO;
import fr.epsi.b3.arosaje.dal.MessageDAO;
import fr.epsi.b3.arosaje.dal.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin("http://localhost:5173/")
public class ConversationController {

    @Autowired
    private ConversationDAO conversationRepository;

    @Autowired
    private UserDAO userRepository;

    @Autowired
    private MessageDAO messageRepository;

    @GetMapping("conversations")
    public List<Conversation> fetchConversations() {
        return conversationRepository.findAll();
    }

    @GetMapping("conversation/{id}")
    public Conversation fetchConversation(@PathVariable long id) {
        return conversationRepository.findById(id).orElse(null);
    }

    @PostMapping("/conversation/add")
    public Conversation addConversation(@RequestBody Conversation conversation,
                                        @RequestParam("senderId") Long senderId,
                                        @RequestParam("receiverId") Long receiverId) {
        User sender = userRepository.findById(senderId).orElse(null);
        User receiver = userRepository.findById(receiverId).orElse(null);

        conversation.setSender(sender);
        conversation.setReceiver(receiver);

        return conversationRepository.save(conversation);
    }

    @GetMapping("/conversation/{id}/messages")
    public List<Message> fetchConversationMessages(@PathVariable long id) {
        Conversation conversation = conversationRepository.findById(id).orElse(null);
        if (conversation != null) {
            return conversation.getMessage_id();
        } else {
            return null;
        }
    }

    @PostMapping("/conversation/{id}/message/add")
    public Message addConversationMessage(@PathVariable long id,
                                          @RequestBody Message message,
                                          @RequestParam("senderId") Long senderId) {
        Conversation conversation = conversationRepository.findById(id).orElse(null);
        User sender = userRepository.findById(senderId).orElse(null);

        message.setConv_id(conversation);
        message.setMessage_sender(sender);

        return messageRepository.save(message);
    }

}
