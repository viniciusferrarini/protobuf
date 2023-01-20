package com.vncsferrarini.protobuf;

import com.vncsferrarini.models.Television;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class VersionCompatibilityTest {

    public static void main(String[] args) throws IOException {

        /*final var television = Television.newBuilder()
                .setBrand("Sony")
                .setYear(2015)
                .build();

        final var pathV1 = Paths.get("tv-v1");
        Files.write(pathV1, television.toByteArray());*/

        // V2
        final var path = Paths.get("tv-v1");
        final byte[] bytes = Files.readAllBytes(path);
        System.out.println(Television.parseFrom(bytes).getType());

    }

}
