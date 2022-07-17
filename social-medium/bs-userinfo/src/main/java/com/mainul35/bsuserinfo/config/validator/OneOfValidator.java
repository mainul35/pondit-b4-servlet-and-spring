//package com.mainul35.bsuserinfo.config.validator;
//
//import com.mainul35.bsuserinfo.config.validator.annotation.OneOf;
//import com.mainul35.bsuserinfo.controllers.dtos.request.Filter;
//import com.mainul35.bsuserinfo.enums.Field;
//
//import javax.validation.ConstraintValidator;
//import javax.validation.ConstraintValidatorContext;
//
//public class OneOfValidator implements ConstraintValidator<OneOf, Filter> {
//
//    private Field field;
//    @Override
//    public void initialize(OneOf constraintAnnotation) {
//        this.field = constraintAnnotation.value();
//    }
//
//    @Override
//    public boolean isValid(String object, ConstraintValidatorContext constraintContext) {
//        if ( object == null ) {
//            return true;
//        }
//
//        if ( caseMode == CaseMode.UPPER ) {
//            return object.equals( object.toUpperCase() );
//        }
//        else {
//            return object.equals( object.toLowerCase() );
//        }
//    }
//}