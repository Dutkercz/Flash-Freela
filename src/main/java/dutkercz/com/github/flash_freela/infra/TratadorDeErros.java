package dutkercz.com.github.flash_freela.infra;

import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.exceptions.TokenExpiredException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

/*Se alguem estiver vendo este repo, peço que me desculpe... tentarei não desenvolver mais nada
usando pt-BR. Essa Classe mesmo, que nome bem feio, mas é isso que ela faz. Obrigado pela compreensão
 */
@RestControllerAdvice
public class TratadorDeErros {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<?> runtimeError(RuntimeException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }

    @ExceptionHandler(JWTVerificationException.class)
    public ResponseEntity<?> tokenExpired(JWTVerificationException e){
        return ResponseEntity.badRequest().body(new JWTVerificationException("Token expirado "+ e.getMessage() ));
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<?> entityNotFound(EntityNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> argumentNotValid(MethodArgumentNotValidException e) {
        List<FieldError> errors = e.getFieldErrors();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(errors.stream()
                        .map(x -> new ValidationError(x.getField(), x.getDefaultMessage()))
                        .toList()
                );
    }
    @ExceptionHandler({UsernameNotFoundException.class, BadCredentialsException.class})
    public ResponseEntity<?> loginError(Exception e){
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Usuário ou Senha inválidos");
    }


    //Para erros que contenham "CAMPO":"MENSAGEM"
    public record ValidationError(String campo,
                                  String mensagem) {
        public ValidationError(FieldError error) {
            this(error.getField(), error.getDefaultMessage());
        }
    }

}
