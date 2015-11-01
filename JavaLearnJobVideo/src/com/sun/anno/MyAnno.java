package com.sun.anno;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(value=RetentionPolicy.RUNTIME)
public @interface MyAnno {
	String show() default "qqqq";
	SuperAnno name();
}
