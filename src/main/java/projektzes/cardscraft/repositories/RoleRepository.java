package projektzes.cardscraft.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;
import projektzes.cardscraft.models.Role;
import projektzes.cardscraft.models.RoleEnum;

@Repository
public interface RoleRepository extends CrudRepository<Role, Integer> {
    Role findByName(RoleEnum name);
}
