package com.vncsferrarini.protobuf.protobuf;

import com.google.protobuf.Int32Value;
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
                .setAge(Int32Value.newBuilder().setValue(30).build())
                .setAddress(address)
                .addAllCar(Arrays.asList(gtr, supra))
                .build();


        System.out.println(person);

    }

}