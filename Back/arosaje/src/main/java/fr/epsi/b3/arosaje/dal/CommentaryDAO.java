package fr.epsi.b3.arosaje.dal;

import fr.epsi.b3.arosaje.bo.Commentary;
import org.springframework.data.repository.CrudRepository;

public interface CommentaryDAO extends CrudRepository<Commentary, Long>{
}
