package ru.demo.downloadmusic;

import java.lang.annotation.*;

@Target(value = ElementType.FIELD)
@Documented
@Retention(value = RetentionPolicy.SOURCE)
public @interface Path {
    String pathTo();
}
