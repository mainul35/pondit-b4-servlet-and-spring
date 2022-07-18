package com.mainul35.bsuserinfo.controllers.dtos.request;

import com.mainul35.bsuserinfo.config.validator.annotation.OneOf;
import com.mainul35.bsuserinfo.enums.Field;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class Filter {
    @NotBlank(message = "Field value must not be blank")
    private String value;
    @OneOf(value = {Field.email, Field.username}, message = "Value must match one of the values in the list: [email, username]")
    private String field;
}