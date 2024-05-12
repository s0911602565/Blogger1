package com.lee.springbootworkspaceblogger.valid;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MyValid implements ConstraintValidator<FieldMatch , Object> {


    @Override
    public void initialize(FieldMatch constraintAnnotation) {
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        return true;
    }
}
