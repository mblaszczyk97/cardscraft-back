package projektzes.cardscraft.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import projektzes.cardscraft.repositories.UserRepository;

@Service
public class ParametersService {
    @Autowired
    public ParametersService(Environment env) {
        secret = env.getProperty("custom.secret.token");
    }
    final private String secret;

    public String getSecret() {
        return secret;
    }
}
