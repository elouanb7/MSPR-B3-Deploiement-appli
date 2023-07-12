package fr.epsi.b3.arosaje.bo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private boolean isRead;

    @Column(nullable = false)
    private LocalDate date;


    @ManyToOne
    @JoinColumn(name = "conv_id")
    private Conversation conv_id;

    @ManyToOne
    @JoinColumn(name = "message_sender")
    private User message_sender; // Utilisateur émetteur



}
