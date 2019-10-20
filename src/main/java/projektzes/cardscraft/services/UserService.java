package projektzes.cardscraft.services;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import projektzes.cardscraft.models.User;
import projektzes.cardscraft.repositories.RoleRepository;
import projektzes.cardscraft.repositories.UserRepository;

import javax.annotation.Resource;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.servlet.ServletException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Base64;
import java.util.Date;

@Service
public class UserService {

    @Autowired
    public UserService(UserRepository userRepository, ParametersService parametersService) {
        this.userRepository = userRepository;
        this.parametersService = parametersService;
    }

    private final ParametersService parametersService;

    private final UserRepository userRepository;

    public void register(User user)  {
        userRepository.save(user);
    }

    public String generateToken(User user) {

        Date now = new Date();
        return Jwts.builder().setSubject(user.getEmail()).setIssuedAt(now)
                .signWith(SignatureAlgorithm.HS256, parametersService.getSecret()).compact();
    }

    public User getUserByToken(String token) {
            final Claims claims = Jwts.parser().setSigningKey(parametersService.getSecret()).parseClaimsJws(token).getBody();
            return userRepository.getByEmail(claims.getSubject());
    }

    public boolean authorize(User user) {
        User userFromDb = userRepository.getByEmail(user.getEmail());
        return userFromDb!=null && isPasswordCorrect(userFromDb,user.getPassword());
    }

    public boolean isPasswordCorrect(User user, String password) {
        String[] pass = user.getPassword().split("\\$");
        KeySpec spec = new PBEKeySpec(password.toCharArray(), pass[2].getBytes(), Integer.valueOf(pass[1]), 256);
        try {
            SecretKeyFactory f = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");
            String passHash = Base64.getEncoder().encodeToString(f.generateSecret(spec).getEncoded());

            return pass[3].equals(passHash);
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            e.fillInStackTrace();
        }
        return false;
    }
    public String hashPassword(String password) {
        String[] pass = new String[3];
        pass[1] = "120000";
        SecureRandom random = new SecureRandom();
        byte bytes[] = new byte[9];
        random.nextBytes(bytes);
        String generatedString =  java.util.Base64.getEncoder().encodeToString(bytes);
        pass[2] = generatedString;
        KeySpec spec = new PBEKeySpec(password.toCharArray(), pass[2].getBytes(), Integer.valueOf(pass[1]), 256);
        try {
            SecretKeyFactory f = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA256");

            String passHash = Base64.getEncoder().encodeToString(f.generateSecret(spec).getEncoded());
            return "pbkdf2_sha256$" + pass[1] + "$" + pass[2] + "$" + passHash;
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            e.fillInStackTrace();
        }
        return null;
    }
}
