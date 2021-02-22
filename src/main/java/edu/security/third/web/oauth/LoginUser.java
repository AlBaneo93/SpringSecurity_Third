package edu.security.third.web.oauth;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/*
 * ArgumentResolver를 이용하여 어느 컨트롤러에서든 세션에 저장된 User 정보를 가져올 수 있도록 하는 어노테이션
 * */
@Target(ElementType.PARAMETER)  // 파라미터로 선언된 객체에서만 사용 가능
@Retention(RetentionPolicy.RUNTIME) // 컴파일 이후에도 JVM에 의해서 참조 가능
public @interface LoginUser {
}