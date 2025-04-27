package dutkercz.com.github.flash_freela.services;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

public class ExpiracaoToken {

    public static Instant expiresToken(){
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }
}
