package proxy;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface CheckNotNull { // method 가 호출될 때 전달되는 parameter 가 null 인지 check
	String[] parameterNames(); // parameterNames attribute 에 복수개의 문자열 value
}