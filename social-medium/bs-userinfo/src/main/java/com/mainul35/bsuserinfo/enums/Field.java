package com.mainul35.bsuserinfo.enums;

import lombok.Getter;

import java.util.Arrays;
import java.util.stream.Stream;

@Getter
public enum Field {
    username("username"),
    email("email");
    private final String value;

    Field(String field) {
        this.value = field;
    }

    public static Field of(String value) {
        return Stream.of(Field.values()).filter(field -> field.getValue().equals(value)).findFirst().orElse(null);
    }

    public static String valuesAsString() {
        String value = "";
        return Arrays.stream(Field.values())
                .map(field -> value.concat(field.toString()).concat(", "))
                .map(s -> s.trim().substring(0, s.length() - 1)).findAny().get();
    }

    @Override
    public String toString() {
        return valuesAsString();
    }
}