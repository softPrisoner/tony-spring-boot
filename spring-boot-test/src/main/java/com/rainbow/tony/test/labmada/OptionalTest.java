package com.rainbow.tony.test.labmada;

import java.util.Optional;

public class OptionalTest {
    public static void main(String[] args) {
        Optional<String> name = Optional.ofNullable("");
        Optional<String> emptyName = Optional.ofNullable(null);
        System.out.println(name.get());
        System.out.println(emptyName.get());
    }
}
