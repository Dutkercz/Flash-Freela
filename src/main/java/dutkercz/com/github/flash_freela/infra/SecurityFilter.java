package dutkercz.com.github.flash_freela.infra;

import dutkercz.com.github.flash_freela.entities.usuario.Usuario;
import dutkercz.com.github.flash_freela.repositories.UsuarioRepository;
import dutkercz.com.github.flash_freela.services.JWTService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class SecurityFilter extends OncePerRequestFilter {
    private final JWTService jwtService;
    private final UsuarioRepository usuarioRepository;

    public SecurityFilter(JWTService jwtService, UsuarioRepository usuarioRepository) {
        this.jwtService = jwtService;
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String requestHeader = request.getHeader("Authorization");

        if (requestHeader != null && requestHeader.startsWith("Bearer ")){
            String cleanToken = requestHeader.replace("Bearer ", "");
            String username = jwtService.getSubject(cleanToken);

            Usuario usuario = (Usuario) usuarioRepository.findByUsername(username)
                    .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado"));

            UsernamePasswordAuthenticationToken userAuth = new UsernamePasswordAuthenticationToken(usuario, null, usuario.getAuthorities());

            if (SecurityContextHolder.getContext().getAuthentication() == null){
                SecurityContextHolder.getContext().setAuthentication(userAuth);
                System.out.println("Usuário autenticado: " + usuario.getUsername());
            }

        }
        filterChain.doFilter(request, response);

    }
}
