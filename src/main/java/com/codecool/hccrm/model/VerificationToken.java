package com.codecool.hccrm.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by prezi on 2017. 02. 06..
 * Last edited by dorasztanko on 2017.02.22..
 */
@Getter
@Setter
@Entity
@Table(name = "verificationToken")
public class VerificationToken extends AbstractEntity {
    private static final int EXPIRATION_TIME = 60 * 24;

    @Column
    private Date expirationDate;

    @Column
    private String token;

    @OneToOne(targetEntity = User.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "user_id")
    private User user;

    protected VerificationToken() {
    }

    public VerificationToken(final String token) {
        this.token = token;
        this.expirationDate = calculateExpirationDate(EXPIRATION_TIME);
    }

    private Date calculateExpirationDate(int expirationTimeInMinutes) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Timestamp(cal.getTime().getTime()));
        cal.add(Calendar.MINUTE, expirationTimeInMinutes);
        return new Date(cal.getTime().getTime());
    }
}
