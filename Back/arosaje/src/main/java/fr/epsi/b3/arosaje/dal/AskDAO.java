package fr.epsi.b3.arosaje.dal;

import fr.epsi.b3.arosaje.bo.Ask;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AskDAO extends CrudRepository<Ask, Long>{
    @Override
    List<Ask> findAll();
}
