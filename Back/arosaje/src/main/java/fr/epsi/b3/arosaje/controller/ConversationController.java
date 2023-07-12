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

    @GetMapping("conversations/user/{userId}")
    public List<Conversation> fetchUserConversations(@PathVariable long userId) {
        User user = userRepository.findById(userId).orElse(null);
        return conversationRepository.findByUser1OrUser2(user, user);
    }
    @GetMapping("conversation/{id}")
    public Conversation fetchConversation(@PathVariable long id) {
        return conversationRepository.findById(id).orElse(null);
    }

    @PostMapping("/conversation/add")
    public Conversation addConversation(@RequestBody Conversation conversation,
                                        @RequestParam("user1") Long user1_id,
                                        @RequestParam("user2") Long user2_id) {
        User user1 = userRepository.findById(user1_id).orElse(null);
        User user2 = userRepository.findById(user2_id).orElse(null);

        conversation.setUser1(user1);
        conversation.setUser2(user2);

        return conversationRepository.save(conversation);
    }

    @GetMapping("/conversation/{id}/messages")
    public List<Message> fetchConversationMessages(@PathVariable long id) {
        Conversation conversation = conversationRepository.findById(id).orElse(null);
        if (conversation != null) {
            return conversation.getMessages();
        } else {
            return null;
        }
    }

/*    @PostMapping("/conversation/{id}/message/add")
    public Message addConversationMessage(@PathVariable long id,
                                          @RequestBody Message message,
                                          @RequestParam("user1") Long user1) {
        Conversation conversation = conversationRepository.findById(id).orElse(null);
        User user1 = userRepository.findById(user1).orElse(null);

        message.setConv_id(conversation);
        message.setMessage_user1(user1);

        return messageRepository.save(message);
    }*/

}
