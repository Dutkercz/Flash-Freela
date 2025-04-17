package dutkercz.com.github.flash_freela.infra;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/*Se alguem estiver vendo este repo, peço que me desculpe... tentarei não desenvolver mais nada
usando pt-BR. Essa Classe mesmo, que nome bem feio, mas é isso que ela faz. Obrigado pela compreensão
 */
@RestControllerAdvice
public class TratadorDeErros {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<?> erroGenerico(RuntimeException e){
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}
