package ua.dp.wheaten.site.root.repositories;

import org.springframework.data.repository.CrudRepository;
import ua.dp.wheaten.site.root.entities.User;

/**
 * Created with IntelliJ IDEA.
 * User: kkm
 * Date: 05.05.15
 * Time: 23:57
 * To change this template use File | Settings | File Templates.
 */
public interface UserRepository extends CrudRepository<User, Integer> {
    User findByLogin(String login);
    User findByEmail(String email);
}
