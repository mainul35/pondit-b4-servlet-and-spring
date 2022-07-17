package com.mainul35.bsuserinfo.controllers.dtos.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class Filter {
    @NotBlank(message = "Field value must not be blank")
    private String value;
    private String field;
}