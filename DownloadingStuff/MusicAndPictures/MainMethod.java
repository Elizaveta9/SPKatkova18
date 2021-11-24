package ru.demo.downloadmusic;

import java.lang.annotation.*;

@Target(value = ElementType.METHOD)
@Documented
@Retention(value = RetentionPolicy.SOURCE)
public @interface MainMethod {
}
