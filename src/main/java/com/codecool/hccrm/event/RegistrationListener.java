package com.codecool.hccrm.event;

import com.codecool.hccrm.model.User;
import com.codecool.hccrm.model.VerificationToken;
import com.codecool.hccrm.service.VerificationTokenService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.MessageSource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UriComponentsBuilder;

import static com.codecool.hccrm.logging.LogFormatter.FORMAT;

/**
 * Created by prezi on 2017. 02. 07..
 * Last edited by dorasztanko on 2017.03.02..
 */
@Component
public class RegistrationListener implements ApplicationListener<OnRegistrationCompleteEvent> {
    private Logger logger = LoggerFactory.getLogger(RegistrationListener.class);
    private final static String PROTOCOL = "http";
    private final static String HOST = "localhost";
    private final static int PORT = 8080;
    private final static String PATH = "/user_verification";
    private final static String PARAM_KEY = "token";

    @Autowired
    private VerificationTokenService verificationTokenService;

    @Autowired
    private MessageSource messages;

    @Autowired
    private JavaMailSender mailSender;

    @Override
    public void onApplicationEvent(OnRegistrationCompleteEvent event) {
        this.confirmRegistration(event);
    }

    private void confirmRegistration(OnRegistrationCompleteEvent event) {
        User user = event.getUser();
        VerificationToken token = verificationTokenService.createVerificationToken(user);
        UriComponentsBuilder builder = UriComponentsBuilder.newInstance()
                .scheme(PROTOCOL)
                .host(HOST)
                .port(PORT)
                .path(PATH)
                .queryParam(PARAM_KEY, token.getToken());
        logger.debug(FORMAT.getFormatter() + builder.toUriString());

        String message = messages.getMessage("message.successful_registration", null, event.getLocale());

        SimpleMailMessage email = new SimpleMailMessage();
        email.setTo(user.getEmail());
        email.setSubject(messages.getMessage("message.email_subject", null, event.getLocale()));
        email.setText(message + "\n" + builder.toUriString());
        mailSender.send(email);
    }
}
