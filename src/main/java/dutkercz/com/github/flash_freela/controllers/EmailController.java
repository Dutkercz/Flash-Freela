package dutkercz.com.github.flash_freela.controllers;

import dutkercz.com.github.flash_freela.services.MailSenderService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/email")
public class EmailController {

    private final MailSenderService mailSenderService;

    public EmailController(MailSenderService mailSenderService) {
        this.mailSenderService = mailSenderService;
    }
}
