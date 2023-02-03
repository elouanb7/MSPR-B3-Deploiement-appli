package fr.epsi.b3.arosaje.dal;

import fr.epsi.b3.arosaje.bo.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserDAO extends CrudRepository<User, Long>{
    @Override
    List<User> findAll();
}
