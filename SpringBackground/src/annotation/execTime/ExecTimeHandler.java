package annotation.execTime;

import java.lang.reflect.Method;

public class ExecTimeHandler {

	// @ExecTime 발견
	public static void handleAnnotation(Object obj) {
		Method[] methods = obj.getClass().getDeclaredMethods();

		for (Method method : methods) {
			if (method.isAnnotationPresent(ExecTime.class)) {
				calcExecTime(obj, method);
			}
		}
	}

	// @ExecTime 처리
	private static void calcExecTime(Object obj, Method method) {
		long startTime = System.currentTimeMillis();
		// 메소드 호출
		try {
			method.invoke(obj);
		} catch (Exception e) {
			e.printStackTrace();
		}
		long endTime = System.currentTimeMillis();
		System.out.println("Execution Time : " + (endTime - startTime));
	}
}