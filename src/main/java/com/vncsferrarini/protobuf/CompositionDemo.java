package com.vncsferrarini.protobuf;

import com.vncsferrarini.models.Person;
import com.vncsferrarini.models.common.Address;
import com.vncsferrarini.models.common.Car;

import java.util.Arrays;

public class CompositionDemo {

    public static void main(String[] args) {
        final var address = Address.newBuilder()
                .setPostbox(123)
                .setStreet("Main street")
                .setCity("San Francisco")
                .build();

        final var gtr = Car.newBuilder()
                .setMake("Nissan")
                .setModel("GTR R34 V-SPEC")
                .setYear(1997)
                .build();

        final var supra = Car.newBuilder()
                .setMake("Toyota")
                .setModel("Supra")
                .setYear(1997)
                .build();

        final var person = Person.newBuilder()
                .setName("Vinicius")
                .setAge(30)
                .setAddress(address)
                .addAllCar(Arrays.asList(gtr, supra))
                .build();


        System.out.println(person);

    }

}