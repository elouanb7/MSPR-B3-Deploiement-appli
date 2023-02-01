package fr.epsi.b3.arosaje.bo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import static jakarta.persistence.GenerationType.*;

@Entity
@Getter
@Setter
public class Commentary {
    @Id
    @GeneratedValue(strategy= IDENTITY)
    private Long id;

    @Column(length=5000, nullable=false)
    private String commentary;
    @ManyToOne
    @JoinColumn(name="ask_id")
    private Ask ask;

    public Commentary() {}
}
