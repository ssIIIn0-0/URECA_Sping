package proxy;

import java.lang.reflect.Proxy;

public class Test {
	public static void main(String[] args) {
		MyIF myIF = new MyIFImpl();

		String param1 = "abc";
		String param2 = null;
//      String param2 = "def";

//      myIF.m(param1, param2);

		// MyIF 타입의 proxy 객체를 생성 호출
		MyIF proxy = (MyIF) Proxy.newProxyInstance(myIF.getClass().getClassLoader(), myIF.getClass().getInterfaces(),
				new CheckNotNullInvocationHandler(myIF));

//      proxy.m(param1, param2);
		proxy.m2(param1, param2);
		proxy.m3(param1, param2);
		proxy.m4(param1, param2);
	}
}