package pl.bernatd.travel_agency.scheduler;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import pl.bernatd.travel_agency.config.AdminConfig;
import pl.bernatd.travel_agency.domain.Mail;
import pl.bernatd.travel_agency.repository.ReservationRepository;
import pl.bernatd.travel_agency.service.SimpleEmailService;

@Component
@RequiredArgsConstructor
public class EmailScheduler {

    private final SimpleEmailService simpleEmailService;
    private final ReservationRepository reservationRepository;
    private final AdminConfig adminConfig;

    @Scheduled(cron = "0 0 10 * * ?")
    public void sendInformationEmail() {
        Long size = reservationRepository.count();
        String message = "Currently in database you got: " + size + " reservation";

        if (size != 1) message += "s";

        simpleEmailService.send(
                Mail.builder()
                        .mailTo(adminConfig.getAdminMail())
                        .subject("Report regarding reservations")
                        .message(message)
                        .build()
        );
    }
}
