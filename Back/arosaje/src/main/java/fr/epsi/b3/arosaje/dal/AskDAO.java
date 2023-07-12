package fr.epsi.b3.arosaje.dal;

import fr.epsi.b3.arosaje.bo.Ask;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
public interface AskDAO extends CrudRepository<Ask, Long>{
    @Override
    List<Ask> findAll();
}
