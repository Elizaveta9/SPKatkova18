package ru.demo.downloadmusic;

import java.lang.annotation.*;

@Target(value = ElementType.TYPE)
@Documented
@Retention(value = RetentionPolicy.SOURCE)
public @interface Class {
    String name();
    String author();

}
