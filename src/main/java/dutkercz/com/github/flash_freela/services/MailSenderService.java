package dutkercz.com.github.flash_freela.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailSenderService {

    private final JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String meuEmail;

    public MailSenderService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void enviarEmail (String para, String assunto, String corpo){
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(para);
        mailMessage.setSubject(assunto);
        mailMessage.setText(corpo);
        mailMessage.setFrom(meuEmail);

        mailSender.send(mailMessage);
    }
}
