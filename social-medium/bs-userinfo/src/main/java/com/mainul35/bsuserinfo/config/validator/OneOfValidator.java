package com.mainul35.bsuserinfo.config.validator;

import com.mainul35.bsuserinfo.config.validator.annotation.OneOf;
import com.mainul35.bsuserinfo.enums.Field;
import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;

public class OneOfValidator implements ConstraintValidator<OneOf, String> {

    private Field[] fields;
    @Override
    public void initialize(OneOf constraintAnnotation) {
        fields = constraintAnnotation.value();
    }

    @Override
    public boolean isValid(String fieldValue, ConstraintValidatorContext constraintContext) {
        return Arrays.asList(fields).contains(Field.of(fieldValue));
    }
}