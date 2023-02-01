package fr.epsi.b3.arosaje.bo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.sql.Blob;

@Entity
@Getter
@Setter
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    private Blob image;

    @ManyToOne
    @JoinColumn(name = "ask_id")
    private Ask ask;

    public Image() {}
}
