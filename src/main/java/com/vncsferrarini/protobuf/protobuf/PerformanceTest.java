package com.vncsferrarini.protobuf.protobuf;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.protobuf.Int32Value;
import com.google.protobuf.InvalidProtocolBufferException;
import com.vncsferrarini.models.Person;
import com.vncsferrarini.protobuf.json.JPerson;

import java.io.IOException;

public class PerformanceTest {

    public static void main(String[] args) {

        final var mapper = new ObjectMapper();

        Runnable jsonRunner = () -> {
            try {
                final var person = new JPerson("Vinicius", 30);
                final byte[] bytes = mapper.writeValueAsBytes(person);
                mapper.readValue(bytes, JPerson.class);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        };

        Runnable protoRunner = () -> {
            try {
                final var person = Person.newBuilder()
                        .setName("Vinicius")
                        .setAge(Int32Value.newBuilder().setValue(30).build())
                        .build();
                final byte[] bytes = person.toByteArray();
                Person.parseFrom(bytes);
            } catch (InvalidProtocolBufferException e) {
                throw new RuntimeException(e);
            }
        };


        for (int i = 0; i < 5; i++) {
            runPerformanceTest(jsonRunner, "JSON");
            runPerformanceTest(protoRunner, "PROTO");
        }

    }

    private static void runPerformanceTest(final Runnable runnable, final String method) {
        final long init = System.currentTimeMillis();
        for (int i = 0; i < 1_000_000; i++) {
            runnable.run();
        }
        final long end = System.currentTimeMillis();
        System.out.println(method + ": " + (end - init) + "ms");
    }

}
