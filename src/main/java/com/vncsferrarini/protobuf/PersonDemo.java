package com.vncsferrarini.protobuf;

import com.vncsferrarini.models.Person;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PersonDemo {

    public static void main(String[] args) throws IOException {
        final Person person = Person.newBuilder()
                .setName("Vinicius")
                .setAge(30)
                .build();

        final Path path = Paths.get("vinicius.ser");
        toByteArray(path, person);
        parseArray(path);
    }

    public static void toByteArray(final Path path, final Person person) throws IOException {
        Files.write(path, person.toByteArray());
    }

    public static void parseArray(final Path path) throws IOException {
        final byte[] bytes = Files.readAllBytes(path);
        final Person parsedPerson = Person.parseFrom(bytes);
        System.out.println(parsedPerson);
    }

}
