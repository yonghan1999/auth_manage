package com.han.auth.base.annotation;

import java.lang.annotation.*;

@Target(ElementType.PARAMETER)//Annotation所修饰的对象范围:方法参数
@Retention(RetentionPolicy.RUNTIME)//Annotation被保留时间:运行时保留(有效)
@Documented//标记注解
public @interface AppName {

}