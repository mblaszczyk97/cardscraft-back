package projektzes.cardscraft.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projektzes.cardscraft.models.Role;
import projektzes.cardscraft.models.RoleEnum;
import projektzes.cardscraft.repositories.RoleRepository;

@Service
public class RoleService {
    @Autowired
    public RoleService(RoleRepository roleRepository) {
       this.roleRepository = roleRepository;
    }
    private final RoleRepository roleRepository;

    public Role getRole(RoleEnum roleEnum) {
        String abc = roleEnum.name();
        return roleRepository.findByName(roleEnum);
    }
}
