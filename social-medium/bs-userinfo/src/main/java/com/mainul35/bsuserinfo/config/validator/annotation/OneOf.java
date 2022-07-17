//package com.mainul35.bsuserinfo.config.validator.annotation;
//
//import com.mainul35.bsuserinfo.config.validator.OneOfValidator;
//import com.mainul35.bsuserinfo.controllers.dtos.request.Filter;
//import com.mainul35.bsuserinfo.enums.Field;
//
//import javax.validation.Constraint;
//import javax.validation.Payload;
//import java.lang.annotation.*;
//
//@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER})
//@Retention(RetentionPolicy.RUNTIME)
//@Documented
//@Constraint(validatedBy = OneOfValidator.class)
//public @interface OneOf {
//    String message() default "Value must match one of the values in the list";
//    Class<?>[] groups() default {};
//    Class<? extends Payload>[] payload() default {};
//    Field value();
//}