package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class CheckNotNullInvocationHandler implements InvocationHandler {
	private Object target;

	public CheckNotNullInvocationHandler(Object target) {
		this.target = target;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// 전달되는 method 객체로 바로 확인 X
		// 한번 거쳐서 method 를 가져와야 된다.
		Method targetMethod = target.getClass().getMethod(method.getName(), method.getParameterTypes());

		// 문제 체크 @CheckNotNull 을 가지고 있는 메소드인지 확인
		if (targetMethod.isAnnotationPresent(CheckNotNull.class)) {
			return handleCheckNotNull(targetMethod, args);
		}

		// @CheckNotNull 가지지 않는 메소드, by pass
		return method.invoke(target, args);
	}

	private Object handleCheckNotNull(Method method, Object[] args) throws Throwable {

		CheckNotNull annotation = method.getAnnotation(CheckNotNull.class);
		String[] parameterNames = annotation.parameterNames();

		for (int i = 0; i < args.length; i++) {
			if (args[i] == null) {
				throw new IllegalArgumentException("Parameter " + parameterNames[i] + " is null (should be notnull)");
			}
		}

		// 문제가 없으면
		return method.invoke(target, args);
	}
}