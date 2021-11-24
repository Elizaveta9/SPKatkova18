package ru.demo.downloadmusic;

import java.lang.annotation.*;

@Target(value = ElementType.CONSTRUCTOR)
@Documented
@Retention(value = RetentionPolicy.SOURCE)
public @interface Constructor {
    String forClass();
}

