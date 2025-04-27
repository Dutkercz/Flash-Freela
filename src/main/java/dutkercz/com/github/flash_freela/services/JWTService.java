package dutkercz.com.github.flash_freela.services;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import dutkercz.com.github.flash_freela.entities.usuario.Usuario;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Date;

@Service
public class JWTService {
    @Value("${algoritmo.password}")
    private String pwAlgoritmo;

    public String createJWT(Usuario usuario){
        try {
            Algorithm algorithm = Algorithm.HMAC256(pwAlgoritmo);
            return JWT.create()
                    .withIssuer("Flash-Freela")
                    .withSubject(usuario.getUsername())
                    .withExpiresAt(ExpiracaoToken.expiresToken())
                    .sign(algorithm);
        } catch (IllegalArgumentException | JWTCreationException e) {
            throw new RuntimeException("Erro ao criar o Token" + e.getMessage());
        }
    }

    public String getSubject(String token){
        try{
            Algorithm algorithm = Algorithm.HMAC256(pwAlgoritmo);
            return JWT.require(algorithm)
                    .withIssuer("Flash-Freela")
                    .build()
                    .verify(token)
                    .getSubject();
        } catch (IllegalArgumentException | JWTVerificationException e) {
            throw new RuntimeException("Erro na verificação do Token " + e.getMessage());
        }
    }
}
