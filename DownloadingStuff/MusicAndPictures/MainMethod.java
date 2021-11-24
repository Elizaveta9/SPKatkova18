package com.company;

import java.lang.annotation.*;

/**
 * Аннотация для обозначения метода main
 * @author Елизавета
 */
@Target(value = ElementType.METHOD)
@Documented
@Retention(value = RetentionPolicy.SOURCE)
public @interface MainMethod {
}
