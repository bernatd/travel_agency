package pl.bernatd.travel_agency.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import pl.bernatd.travel_agency.domain.Mail;

import static java.util.Optional.ofNullable;

@Slf4j
@Service
@RequiredArgsConstructor
public class SimpleEmailService {

    private final JavaMailSender javaMailSender;

    public void send(final Mail mail) {
        try {
            javaMailSender.send(createMailMessage(mail));
        } catch (MailException e) {
            log.error("Failed to process email sending: " + e.getMessage(), e);
        }

    }

    private SimpleMailMessage createMailMessage(final Mail mail) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(mail.getMailTo());
        mailMessage.setSubject(mail.getSubject());
        mailMessage.setText(mail.getMessage());

        ofNullable(mail.getToCc()).ifPresent( cc -> mailMessage.setCc(mail.getToCc()));

        return mailMessage;
    }
}
