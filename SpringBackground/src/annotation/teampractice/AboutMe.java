package annotation.teampractice;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE) // class 에 사용할 annotation
public @interface AboutMe {
	// attribute (추상 메소드)
	String name();
	String mbti();
}
