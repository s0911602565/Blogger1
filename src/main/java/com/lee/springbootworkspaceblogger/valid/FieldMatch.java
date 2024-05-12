package com.lee.springbootworkspaceblogger.valid;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = MyValid.class)
public @interface FieldMatch {
    String message()default "";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}

