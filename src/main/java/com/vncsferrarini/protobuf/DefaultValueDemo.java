package com.vncsferrarini.protobuf;

import com.vncsferrarini.models.Person;

public class DefaultValueDemo {

    public static void main(String[] args) {

        final Person person = Person.newBuilder().build();
        System.out.println("City: " + person.getAddress().getCity());

    }

}
