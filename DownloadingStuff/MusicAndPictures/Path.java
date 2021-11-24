package com.company;

import java.lang.annotation.*;

/**
 * Аннотация для обозначения переменной, содержащей путь
 * @author Елизавета
 */
@Target(value = ElementType.FIELD)
@Documented
@Retention(value = RetentionPolicy.SOURCE)
public @interface Path {
    String pathTo();
}
