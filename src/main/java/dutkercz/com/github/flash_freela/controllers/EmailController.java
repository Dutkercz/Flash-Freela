package dutkercz.com.github.flash_freela.controllers;

import dutkercz.com.github.flash_freela.entities.EmailRequest;
import dutkercz.com.github.flash_freela.entities.EmailResponse;
import dutkercz.com.github.flash_freela.services.MailSenderService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/email")
public class EmailController {

    private final MailSenderService mailSenderService;

    public EmailController(MailSenderService mailSenderService) {
        this.mailSenderService = mailSenderService;
    }

    @PostMapping
    public ResponseEntity<EmailResponse> enviarEmail(@Valid @RequestBody EmailRequest request){
        mailSenderService.enviarEmail(request.para(), request.assunto(), request.assunto());
        return ResponseEntity.ok(new EmailResponse("Email enviado para " + request.para()));

    }
}
