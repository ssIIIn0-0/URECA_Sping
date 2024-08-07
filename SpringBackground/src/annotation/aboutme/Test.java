package annotation.aboutme;

import java.lang.annotation.Annotation;
import info;
// reflection 을 이용해서 annotation 확인
public class Test {

//	public static void main(String[] args) throws Exception{
//		Class<?> myClass = Class.forName("annotation.aboutme.MyClass");
//		
//		Annotation[] annotations = myClass.getAnnotations();
//		for (Annotation annotation : annotations) {
//			if(annotation instanceof AboutMe) {
//				AboutMe aboutMe = (AboutMe) annotation;
//				System.out.println(aboutMe.love());
//				System.out.println(aboutMe.hate());
//			}
//		}
//	}

	public static void main(String[] args) throws Exception{
		Class<?> myClass = Class.forName("info.MyClass");
		
		Annotation[] annotations = myClass.getAnnotations();
		for (Annotation annotation : annotations) {
			if(annotation instanceof info) {
				AboutMe aboutMe = (AboutMe) annotation;
				System.out.println(aboutMe.author());
				System.out.println(aboutMe.version());
			}
		}
	}
}
