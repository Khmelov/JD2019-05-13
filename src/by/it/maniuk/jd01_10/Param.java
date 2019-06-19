package by.it.maniuk.jd01_10;

import java.lang.annotation.*;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Param {
    int a();
    int b();
}
