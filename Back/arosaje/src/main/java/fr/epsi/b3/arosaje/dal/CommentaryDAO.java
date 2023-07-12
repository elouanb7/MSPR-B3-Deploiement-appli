package fr.epsi.b3.arosaje.dal;

import fr.epsi.b3.arosaje.bo.Ask;
import fr.epsi.b3.arosaje.bo.Commentary;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CommentaryDAO extends CrudRepository<Commentary, Long>{

    List<Commentary> findByAsk(Ask ask);
}
