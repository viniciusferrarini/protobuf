package com.vncsferrarini.protobuf.protobuf;

import com.vncsferrarini.models.Credentials;
import com.vncsferrarini.models.EmailCredentials;
import com.vncsferrarini.models.PhoneOPT;

public class OneOfDemo {

    public static void main(String[] args) {

        final var emailCredential = EmailCredentials.newBuilder()
                .setEmail("vncsferrarini@mail.com")
                .setPassword("123")
                .build();

        final var phoneCredential = PhoneOPT.newBuilder()
                .setNumber(1234567)
                .setCode(46)
                .build();

        final var credentials = Credentials.newBuilder()
                .setEmailMode(emailCredential)
                .setPhoneMode(phoneCredential)
                .build();

        login(credentials);

    }

    private static void login(final Credentials credentials) {

        switch (credentials.getModeCase()) {
            case EMAILMODE:
                System.out.println(credentials.getEmailMode());
                break;
            case PHONEMODE:
                System.out.println(credentials.getPhoneMode());
                break;
        }

        System.out.println(credentials.getEmailMode());
    }

}
