package fr.epsi.b3.arosaje.dal;

import fr.epsi.b3.arosaje.bo.Plant;
import org.springframework.data.repository.CrudRepository;

public interface PlantDAO extends CrudRepository<Plant, Long>{
}
