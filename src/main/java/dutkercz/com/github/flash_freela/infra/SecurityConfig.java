package dutkercz.com.github.flash_freela.infra;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
@Configuration
public class SecurityConfig {
    private final SecurityFilter securityFilter;
    private final JwtAuthEntryPoint entryPoint;

    public SecurityConfig(SecurityFilter securityFilter, JwtAuthEntryPoint entryPoint) {
        this.securityFilter = securityFilter;
        this.entryPoint = entryPoint;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity security) {
        try {
            return security.csrf(AbstractHttpConfigurer::disable)
                    .sessionManagement(x -> x.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                    .authorizeHttpRequests(x ->
                    {
                        x.requestMatchers("/usuarios/**").permitAll();
                        x.requestMatchers("/email/**").permitAll();
                        x.anyRequest().authenticated();
                    })
                    .addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class)
                    .exceptionHandling(x ->
                           x.authenticationEntryPoint(entryPoint))
                    .build();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration){
        try {
            return configuration.getAuthenticationManager();
        } catch (Exception e) {
            throw new RuntimeException("Erro de autenticação " + e.getMessage());
        }

    }
}
