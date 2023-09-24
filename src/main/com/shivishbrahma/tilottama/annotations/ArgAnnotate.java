package com.shivishbrahma.tilottama.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Map Annotation Interface
 *
 * @author Purbayan Chowdhury<a href=
 * "mailto:pur.cho.99@gmail.com">pur.cho.99@gmail.com</a>
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ArgAnnotate {
    String name() default "arg";

    Class dataType() default String.class;

    String dataDefault() default "";
}
