package com.company;

import java.lang.annotation.*;

/**
 * Аннотация для конструктора
 * @author Елизавета
 */
@Target(value = ElementType.CONSTRUCTOR)
@Documented
@Retention(value = RetentionPolicy.SOURCE)
public @interface Constructor {
    String forClass();
}

