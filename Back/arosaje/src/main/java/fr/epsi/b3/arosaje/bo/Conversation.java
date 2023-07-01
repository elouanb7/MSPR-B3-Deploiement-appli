package fr.epsi.b3.arosaje.bo;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Conversation {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "sender_id")
    private User sender;

    @ManyToOne
    @JoinColumn(name = "recever_id")
    private User recever;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "conv_id")
    private List<Message> message_id;

}
