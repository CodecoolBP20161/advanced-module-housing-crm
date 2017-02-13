package com.codecool.hccrm.event;

import com.codecool.hccrm.model.User;
import com.codecool.hccrm.service.UserService;
import com.codecool.hccrm.service.VerificationTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.MessageSource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;


import java.util.UUID;

/**
 * Created by prezi on 2017. 02. 07..
 */
@Component
public class RegistrationListener implements
        ApplicationListener<OnRegistrationCompleteEvent> {

    @Autowired
    private UserService userService;

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
        String token = UUID.randomUUID().toString();
        userService.createVerificationToken(user, token);

        String recipientAddress = user.getEmail();
        String subject = "Registration Confirmation";
        String confirmationUrl
                = event.getAppUrl() + "/regitrationConfirm.html?token=" + token;
        String message = messages.getMessage("message.regSucc", null, event.getLocale());

        SimpleMailMessage email = new SimpleMailMessage();
        email.setTo(recipientAddress);
        email.setSubject(subject);
        email.setText(message + "\n" + "http://localhost:8080" + confirmationUrl);
        mailSender.send(email);
    }
}
