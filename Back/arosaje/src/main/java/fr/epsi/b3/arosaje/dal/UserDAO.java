package fr.epsi.b3.arosaje.dal;

import fr.epsi.b3.arosaje.bo.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import java.util.List;
@CrossOrigin(origins = "http://localhost:5173")
public interface UserDAO extends CrudRepository<User, Long>{
    @Override
    List<User> findAll();
}
