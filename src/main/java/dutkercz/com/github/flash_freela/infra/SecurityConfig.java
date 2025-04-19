package dutkercz.com.github.flash_freela.infra;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.AbstractRequestMatcherRegistry;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@EnableWebSecurity
@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity security){
        try{
            return security.csrf(AbstractHttpConfigurer::disable)
                    .sessionManagement(x -> x.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                    .build();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    @Bean
    public PasswordEncoder encoder(){
        return new BCryptPasswordEncoder();
    }
}
