package fr.epsi.b3.arosaje.bo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Plant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 500, nullable = false)
    private String name;
    @Column(length = 500, nullable = false)
    private String latinName;
    @Column(length = 5000, nullable = false)
    private String description;
    @Column(nullable = false)
    private String species;
    @Column(nullable = false)
    private Integer wateringFrequency;
    @Column(nullable = false)
    private Integer sunExposure ;

    @ManyToOne
    @JoinColumn(name = "botanist_id")
    private Botanist botanist;

    //ask jointure
    @OneToMany(mappedBy="plant")
    private List<Ask> Asks;


    public Plant() {}
}
