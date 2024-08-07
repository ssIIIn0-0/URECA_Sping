package annotation.execTime;

public class Test {

	public static void main(String[] args) {
		MyClass mc = new MyClass();

		// 직접 메소드 호출
		mc.m();

		// reflection 으로 객체의 annotation 을 이용한 호출
		ExecTimeHandler.handleAnnotation(mc);
	}

}