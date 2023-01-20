package com.vncsferrarini.protobuf.protobuf;

import com.vncsferrarini.models.Dealer;
import com.vncsferrarini.models.common.BodyStyle;
import com.vncsferrarini.models.common.Car;

public class MapDemo {

    public static void main(String[] args) {

        final var gtr = Car.newBuilder()
                .setMake("Nissan")
                .setModel("GTR R34 V-SPEC")
                .setYear(1997)
                .setBodyStyle(BodyStyle.SPORT)
                .build();

        final var supra = Car.newBuilder()
                .setMake("Toyota")
                .setModel("Supra")
                .setBodyStyle(BodyStyle.SPORT)
                .setYear(1996)
                .build();

        final var dealer = Dealer.newBuilder()
                .putModel(1997, gtr)
                .putModel(1996, supra)
                .build();

        System.out.println(dealer.toString());

        System.out.println(dealer.getModelOrThrow(1997));

        // If not found by key returns supra
        System.out.println(dealer.getModelOrDefault(2000, supra));
        System.out.println(dealer.getModelMap());
    }

}
