package annotation.execTime;

public class MyClass {

	@ExecTime
	public void m() {
		System.out.println("m() start");
		try {
			Thread.sleep(4000); // 4초간 진행 멈춤.
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("m() end");
	}
}