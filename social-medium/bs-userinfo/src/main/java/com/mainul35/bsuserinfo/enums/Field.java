package com.mainul35.bsuserinfo.enums;

import lombok.Getter;

@Getter
public enum Field {
    username("username"),
    email("email");

    private String value;

    Field(String field) {
        this.value = field;
    }
}