package com.company;

import java.lang.annotation.*;

/**
 * Аннотация для класса
 * @author Елизавета
 */
@Target(value = ElementType.TYPE)
@Documented
@Retention(value = RetentionPolicy.SOURCE)
public @interface Class {
    String name();
    String author();
}
