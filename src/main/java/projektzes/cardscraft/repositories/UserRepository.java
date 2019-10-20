package projektzes.cardscraft.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import projektzes.cardscraft.models.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {
    User getByEmail(String email);
    User getByEmailAndPassword(String email, String password);
}
