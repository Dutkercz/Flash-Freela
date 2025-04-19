package dutkercz.com.github.flash_freela.infra;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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


    //Para erros que contenham "CAMPO":"MENSAGEM"
    public record ValidationError(String campo,
                                  String mensagem) {
        public ValidationError(FieldError error) {
            this(error.getField(), error.getDefaultMessage());
        }
    }

}
