package fr.epsi.b3.arosaje.dal;

import fr.epsi.b3.arosaje.bo.User;
import org.springframework.data.repository.CrudRepository;

public interface UserDAO extends CrudRepository<User, Long>{
}
